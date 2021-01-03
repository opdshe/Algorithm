package 브루트포스;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 수식최대화 {
    static List<String> split = new ArrayList<>();
    static List<String> operatorList = new ArrayList<>();
    static Set<String> operatorSet = new HashSet<>();
    static int[] orders;
    static boolean[] visited;
    static long answer = 0;

    public static void main(String[] args) {
        solution("50*6-3*2");
    }

    public static long solution(String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int idx = 0; idx < expression.length(); idx++) {
            char current = expression.charAt(idx);
            if (!Character.isDigit(current)) {
                operatorList.add(String.valueOf(current));
                operatorSet.add(String.valueOf(current));
                split.add(stringBuilder.toString());
                split.add(String.valueOf(current));
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(current);
            }
        }
        split.add(stringBuilder.toString());
        orders = new int[operatorSet.size()];
        visited = new boolean[operatorSet.size()];

        dfs(0);
        return answer;
    }

    private static void dfs(int position) {
        if (position == orders.length) {
            List<String> copySplit = new ArrayList<>(split);
            List<String> operators = new ArrayList(operatorSet);
            for (int order : orders) {
                String operator = operators.get(order);
                while (copySplit.contains(operator)) {
                    int operatorIdx = copySplit.indexOf(operator);
                    long a = Long.parseLong(copySplit.remove(operatorIdx - 1));
                    copySplit.remove(operatorIdx - 1);
                    long b = Long.parseLong(copySplit.remove(operatorIdx - 1));
                    long result = calculate(a, b, operator);
                    copySplit.add(operatorIdx - 1, String.valueOf(result));
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(copySplit.get(0))));
            return;
        }
        for (int order = 0; order < orders.length; order++) {
            if (!visited[order]) {
                visited[order] = true;
                orders[position] = order;
                dfs(position + 1);
                visited[order] = false;
            }
        }
    }

    private static long calculate(long a, long b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
