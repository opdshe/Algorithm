package 백준.다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 연속합 {
	static int[] cache;
	static int[] numbers;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumbers = scanner.nextInt();
		numbers = new int[countOfNumbers];
		cache = new int[countOfNumbers];
		for (int i = 0; i < countOfNumbers; i++) {
			numbers[i] = scanner.nextInt();
		}
		cache[0] = numbers[0];
		for (int i = 1; i < countOfNumbers; i++) {
			int sum = cache[i - 1] + numbers[i];
			cache[i] = Math.max(sum, numbers[i]);
		}
		int answer = Arrays.stream(cache)
				.max()
				.getAsInt();
		System.out.println(answer);

	}
}
