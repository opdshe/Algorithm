package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 예산 {
    public static void main(String[] args) {
        solution(new int[]{120, 110, 140, 150}, 485);
    }

    public static int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        int start = 0;
        int end = budgets[budgets.length-1];
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for (Integer budget : budgets) {
                if (mid >= budget) {
                    sum += budget;
                    continue;
                }
                sum += mid;
            }
            if (sum > M) {
                end = mid -1;
                continue;
            }
            if (sum < M) {
                start = mid+ 1;
                continue;
            }
            break;
        }
        return end;
    }
}
