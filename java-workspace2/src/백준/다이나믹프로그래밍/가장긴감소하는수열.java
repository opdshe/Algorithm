package 백준.다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴감소하는수열 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int countOfNum = scanner.nextInt();
		int[] cache = new int[countOfNum];
		int[] numbers = new int[countOfNum];
		for (int i = 0; i < countOfNum; i++) {
			numbers[i] = scanner.nextInt();
		}
		for (int i = 0; i < countOfNum; i++) {
			if (i == 0) {
				cache[i] = 1;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (numbers[i] < numbers[j] && cache[i] <= cache[j]) {
					cache[i] = cache[j] + 1;
				}
			}
			if (cache[i] == 0) {
				cache[i] = 1;
			}
		}
		System.out.println(Arrays.stream(cache).max().getAsInt());
	}
}
