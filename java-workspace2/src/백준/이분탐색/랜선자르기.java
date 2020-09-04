package 백준.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 랜선자르기 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int K;
	static int[] lan;
	static long answer = 0;

	public static void main(String[] args) {
		K = scanner.nextInt();
		N = scanner.nextInt();
		lan = new int[K];
		for (int i = 0; i < K; i++) {
			lan[i] = scanner.nextInt();
		}
		Arrays.sort(lan);
		search();
	}

	private static void search() {
		if (N == K) {

		}
		long left = 0;
		long right = lan[K - 1];

		while (left <= right) {
			int count = 0;

			long mid = (left + right) / 2;
			for (int l : lan) {
				if (mid == 0) {
					mid = 1;
				}
				count += (l / mid);
			}

			if (count < N) {
				right = mid - 1;
			} else {
				answer = Math.max(answer, mid);
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
