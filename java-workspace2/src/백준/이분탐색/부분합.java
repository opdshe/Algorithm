package 백준.이분탐색;

import java.util.Arrays;
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
		Arrays.sort(numbers);
		search();
	}

	private static void search() {

	}
}
