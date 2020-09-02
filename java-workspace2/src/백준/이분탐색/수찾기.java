package 백준.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int M;
	static int[] numbers;

	public static void main(String[] args) {
		N = scanner.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scanner.nextInt();
		}

		Arrays.sort(numbers);
		M = scanner.nextInt();
		for (int i = 0; i < M; i++) {
			int targets = scanner.nextInt();
			System.out.println(search(targets));
		}
	}

	private static int search(int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int midValue = numbers[mid];
			if (midValue == target) {
				return 1;
			}
			if (midValue > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 0;
	}
}
