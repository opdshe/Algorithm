package 코테대비중요문제;

import java.util.Arrays;

public class 입국심사 {
	public static void main(String[] args) {
		solution(6, new int[]{7, 10});
	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times);
		return binarySearch(n, times);
	}

	private static long binarySearch(int n, int[] times) {
		long left = 0;
		long right = times[times.length - 1] * n;
		long answer = Long.MAX_VALUE;
		while (left <= right) {
			long count = 0;
			long mid = (left + right) / 2;
			for (int time : times) {
				count += (mid / time);
			}
			if (count >= n) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
		return answer;
	}
}