package 프로그래머스;

import java.util.Arrays;

public class 예산2 {
    public static void main(String[] args) {
        solution(new int[]{120, 110, 140, 150}, 485);
    }

    public static int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        int left = 0;
        int right = budgets[budgets.length - 1];
        int answer=0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int budget : budgets) {
                if (budget <= mid) {
                    sum += budget;
                } else {
                    sum += mid;
                }
            }
            if (sum > M) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid +1;
            }
        }
        System.out.println(answer);
        return 0;
    }
}