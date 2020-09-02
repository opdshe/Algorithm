package 백준.이분탐색;

import java.util.Scanner;

public class 부분합 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static long M;
	static int[] numbers;

	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextLong();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scanner.nextInt();
		}
		search();

	}

	private static void search() {
		int leftIdx = 0;
		int rightIdx = 0;
		long sum = 0;
		int diff = N;

		while (true) {
			if (sum >= M) {
				sum -= numbers[leftIdx++];
				diff = Math.min(diff, (rightIdx - leftIdx + 1));
			} else if (rightIdx == N) {
				break;
			} else {
				sum += numbers[rightIdx++];
			}

		}
		System.out.println(diff);
	}


}
