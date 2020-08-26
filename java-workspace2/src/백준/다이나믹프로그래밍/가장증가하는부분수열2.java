package 백준.다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 가장증가하는부분수열2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int countOfNumbers = scanner.nextInt();
		int[] numbers = new int[countOfNumbers];
		int[] cache = new int[countOfNumbers];
		int answer = 0;

		cache[0] = 1;

		for (int i = 0; i < countOfNumbers; i++) {
			numbers[i] = scanner.nextInt();
		}

		for (int i = 1; i < countOfNumbers; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers[i] > numbers[j] && cache[i] <= cache[j]) {
					cache[i] = cache[j] + 1;
				}
			}
			if (cache[i] == 0) {
				cache[i] = 1;
			}
			answer = Math.max(answer, cache[i]);
		}

		System.out.println(Arrays.stream(cache)
				.max().getAsInt());
	}
}
