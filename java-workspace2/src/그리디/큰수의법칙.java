package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int K = scanner.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scanner.nextInt();
		}
		Arrays.sort(numbers);
		int maxValue = numbers[numbers.length - 1];
		int secondValue = numbers[numbers.length - 2];

		int count = (M / (K + 1)) * K;
		count += M % (K + 1);

		int total = 0;
		total += count * maxValue;
		total += secondValue * (M - count);
		System.out.println(total);
	}

}
