package 백준.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 두용액 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static long[] waters;

	public static void main(String[] args) {
		N = scanner.nextInt();
		waters = new long[N];
		for (int i = 0; i < N; i++) {
			waters[i] = scanner.nextLong();
		}
		Arrays.sort(waters);
		search();
	}

	private static void search() {
		int left = 0;
		int right = N - 1;
		long leftAnswer = waters[0];
		long rightAnswer = waters[N - 1];
		long diff = Math.abs(Long.MAX_VALUE);

		while (left < right) {
			long sum = waters[left] + waters[right];
			long currentDiff = Math.abs(sum);
			if (sum == 0) {
				leftAnswer = waters[left];
				rightAnswer = waters[right];
				break;
			}
			if (currentDiff < diff) {
				rightAnswer = waters[right];
				leftAnswer = waters[left];
				diff = currentDiff;
			}
			if (sum >= 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(leftAnswer + " " + rightAnswer);
	}
}
