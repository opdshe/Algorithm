package 완전탐색;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    static int[] idxes;
    static boolean[] visited;
    static Set<Integer> answers = new HashSet<>();

    public static void main(String[] args) {
        solution("17");
    }

    public static int solution(String numbers) {
        idxes = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        comb(numbers, 0);
        return answers.size();
    }

    private static void comb(String numbers, int idx) {
        if (idx == numbers.length()) {
            StringBuilder strNumber = new StringBuilder();
            for (int i = 0; i < numbers.length(); i++) {
                strNumber.append(numbers.charAt(idxes[i]));
            }
            int intNumber = Integer.parseInt(strNumber.toString());
            if(isPrimeNumber(intNumber)){
                answers.add(intNumber);
            }
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                idxes[idx] = i;
                comb(numbers, idx + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }
        for (int num = 2; num < number; num++) {
            if (number % num == 0) {
                return false;
            }
        }
        return true;
    }
}
