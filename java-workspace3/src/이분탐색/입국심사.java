package 이분탐색;

import java.util.Arrays;

public class 입국심사 {
	public long solution(int n, int[] times) {
		Arrays.sort(times);
		return getMinTime(times, n);
	}

	private static long getMinTime(int[] times, int n) {
		long left = 1;
		long right = (long) times[times.length - 1] * n;
		long answer = right;

		while (left < right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int time : times) {
				sum += mid / time;
			}
			if (sum < n) {
				left = mid + 1;
			} else {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}
		}
		return answer;
	}
}
