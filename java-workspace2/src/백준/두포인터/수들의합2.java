package 백준.두포인터;

import java.util.Scanner;

public class 수들의합2 {
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
		long sum = 0;
		int count = 0;
		int leftIdx = 0;
		int rightIdx = 0;
		while (true) {
			if (sum > M) {
				sum -= numbers[leftIdx];
				if (sum == M) {
					count++;
				}
				leftIdx++;
			} else if (rightIdx == N) {
				break;
			} else {
				sum += numbers[rightIdx];
				if (sum == M) {
					count++;
				}
				rightIdx++;
			}
		}
		System.out.println(count);
	}
}
