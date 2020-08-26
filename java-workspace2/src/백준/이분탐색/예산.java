package 백준.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 예산 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int countOfCity = scanner.nextInt();
		int[] cities = new int[countOfCity];
		for (int i = 0; i < countOfCity; i++) {
			cities[i] = scanner.nextInt();
		}
		int budget = scanner.nextInt();
		BinarySearch(cities, budget);
	}

	private static void BinarySearch(int[] cities, int budget) {
		Arrays.sort(cities);
		long left = 0;
		long right = cities[cities.length - 1];
		long answer = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int city : cities) {
				if (city > mid) {
					sum += mid;
					continue;
				}
				sum += city;
			}
			if (sum > budget) {
				right = mid - 1;
			} else {
				answer = mid;
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
