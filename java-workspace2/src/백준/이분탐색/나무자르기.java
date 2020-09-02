package 백준.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 나무자르기 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int M;
	static long[] trees;
	static long answer;

	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		trees = new long[N];
		for (int i = 0; i < N; i++) {
			trees[i] = scanner.nextInt();
		}
		Arrays.sort(trees);
		System.out.println(search(M));
	}

	private static long search(long target) {
		long left = 0;
		long right = trees[N - 1];
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (long height : trees) {
				if (height > mid) {
					sum += (height - mid);
				}
			}
			if (sum >= target) {
				left = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				right = mid - 1;
			}
		}
		return answer;
	}
}
