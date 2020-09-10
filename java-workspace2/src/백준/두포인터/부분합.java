package 백준.두포인터;

import java.util.Scanner;

public class 부분합 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int M;
	static int[] numbers;

	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		numbers = new int[N];
		for (int idx = 0; idx < N; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		search();
	}

	private static void search() {
		int left = 0;
		int right = 0;
		long sum = 0;
		int answer = Integer.MAX_VALUE;

		while (true) {
			if (sum >= M) {
				answer = Math.min(answer, right - left);
				sum -= numbers[left++];
			} else if (right == N) {
				break;
			} else {
				sum += numbers[right++];
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}
