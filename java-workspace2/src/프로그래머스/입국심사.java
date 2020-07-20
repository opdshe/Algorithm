package 프로그래머스;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        solution(6, new int[]{7, 10});
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = n;
        long right = times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            if(isAvailable(n, mid, times)){
                answer = Math.min(answer, mid);
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean isAvailable(int n, long mid, int[] times) {
        long finished = 0;
        for (int time : times) {
            finished += mid / time;
        }
        return finished >= n;
    }
}
