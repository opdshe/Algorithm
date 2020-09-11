package 프로그래머스.이분탐색;

public class 입국심사 {
    public static void main(String[] args) {
        solution(6, new int[]{7, 10});
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = times[times.length - 1] * n;

        while (left <= right) {
            long mid = (left + right) / 2;
            System.out.println("mid : " + mid);
            int count = 0;
            for (int time : times) {
                count += (mid / time);
            }
            if (count >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
