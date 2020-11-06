package 코테대비중요문제;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기설치 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfHouse = scanner.nextInt();
		int countOfMachine = scanner.nextInt();
		int[] houses = new int[countOfHouse];
		for (int idx = 0; idx < countOfHouse; idx++) {
			houses[idx] = scanner.nextInt();
		}
		Arrays.sort(houses);
		solution(houses, countOfMachine, countOfHouse);
	}

	private static void solution(int[] houses, int countOfMachine, int countOfHouse) {
		int left = 1;
		int right = houses[countOfHouse - 1] - houses[0];
		int answer = -1;
		while (left <= right) {
			int count = 1;
			int currentPosition = houses[0];
			int mid = (left + right) / 2;
			for (int idx = 1; idx < countOfHouse; idx++) {
				if (houses[idx] - currentPosition >= mid) {
					count++;
					currentPosition = houses[idx];
				}
			}
			if (count < countOfMachine) {
				right = mid - 1;
			} else {
				answer = Math.max(answer, mid);
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
