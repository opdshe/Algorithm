package programmers.binarysearch;

import java.util.Arrays;

public class 예산 {
    public static void main(String[] args) {
        solution(new int[]{120, 110, 140, 150}, 485);
    }

    public static int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        int min = 0;
        int max = budgets[budgets.length - 1];
        int mid = (min + max) / 2;
        int sum = Arrays.stream(budgets)
                .sum();
        if (sum <= M) {
            return max;
        }

        while (min <= max) {
            sum = 0;
            mid = (min+max)/2;
            for (int budget : budgets) {
                sum = budget >= mid ? sum + mid : sum + budget;
            }
            if (sum > M) {
                max = mid -1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max);
        return max;
    }

}
