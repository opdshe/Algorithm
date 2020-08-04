package 프로그래머스;

import java.util.Arrays;

public class 입국심사2 {
    public static void main(String[] args) {
        solution(6, new int[]{7, 10});
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = (long)0;
        long max = times[times.length - 1] * n;
        long answer = 0;

        while (min <= max) {
            System.out.println("min: " + min);
            System.out.println("max: " + max);
            long mid = (min + max) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }
            if (sum >= n){
                answer = Math.min(answer, mid);
                max = mid -1;
            }else {
                min = mid+1;
                answer = mid;
            }
        }
        System.out.println("answer : " + answer);
        return 0;
    }
}
