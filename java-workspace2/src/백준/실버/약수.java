package 백준.실버;

import java.util.Arrays;
import java.util.Scanner;

public class 약수 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scanner.nextInt();
		}
		Arrays.sort(numbers);
		System.out.println(numbers[0] * numbers[N - 1]);
	}
}
