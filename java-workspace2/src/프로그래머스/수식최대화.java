package 프로그래머스;

import java.util.*;

public class 수식최대화 {
    static List<List<String>> priorities = new ArrayList<>();
    static long answer = 0;

    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }

    public static long solution(String expression) {
        List<String> symbols = initSymbols(expression);
        setPermutation(symbols, new ArrayList<>());
        for (List<String> priority : priorities) {
            long prize = getPrize(symbols, priority, expression);
            answer = Math.max(answer, Math.abs(prize));
        }
        System.out.println(answer);
        return answer;
    }

    private static void setPermutation(List<String> symbols, List<String> currentList) {
        if (currentList.size() == symbols.size()) {
            priorities.add(currentList);
        }
        for (String symbol : symbols) {
            if (!currentList.contains(symbol)) {
                List<String> newList = new ArrayList<>(currentList);
                newList.add(symbol);
                setPermutation(symbols, newList);
            }
        }
    }

    private static long getPrize(List<String> symbols, List<String> priority, String expression) {
        List<String> expressionList = getExpressionList(expression);
        long symbolSize = symbols.size();
        for (int i = 0; i < symbolSize; i++) {
            String symbol = priority.remove(0);
            while (expressionList.contains(symbol)) {
                operate(expressionList, symbol);
            }
        }
        return Long.parseLong(expressionList.get(0));
    }

    private static void operate(List<String> expressionList, String symbol) {
        //System.out.println(Arrays.toString(expressionList.toArray()));
        int symbolIdx = expressionList.indexOf(symbol);
        long left = Long.parseLong(expressionList.get(symbolIdx - 1));
        long right = Long.parseLong(expressionList.get(symbolIdx + 1));

        for (int i = 0; i < 3; i++){
            expressionList.remove(symbolIdx-1);
        }
        expressionList.add(symbolIdx-1,String.valueOf(calculate(left, right, symbol)));
    }

    private static long calculate(long left, long right, String symbol) {
        if (symbol.equals("+")) {
            return left + right;
        }
        if (symbol.equals("-")) {
            return left - right;
        }
        return left * right;
    }

    private static List<String> getExpressionList(String expression) {
        List<String> expressionList = new ArrayList<>();
        int leftIdx = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (String.valueOf(expression.charAt(i)).matches("[*+-]")) {
                expressionList.add(expression.substring(leftIdx, i));
                expressionList.add(String.valueOf(expression.charAt(i)));
                leftIdx = i + 1;
            }
        }
        expressionList.add(expression.substring(leftIdx));
        //System.out.println(Arrays.toString(expressionList.toArray()));
        return expressionList;
    }

    private static List<String> initSymbols(String expression) {
        List<String> symbols = new ArrayList<>();
        Arrays.stream(expression.split(""))
                .distinct()
                .forEach(character -> {
                    if (character.matches("[*+-]")) {
                        symbols.add(character);
                    }
                });
        return symbols;
    }
}
