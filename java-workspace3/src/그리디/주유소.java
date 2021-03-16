package 그리디;

import java.util.Scanner;

public class 주유소 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfCity = scanner.nextInt();
		int[] needs = new int[countOfCity - 1];
		int[] costs = new int[countOfCity];
		for (int idx = 0; idx < countOfCity - 1; idx++) {
			needs[idx] = scanner.nextInt();
		}
		for (int idx = 0; idx < countOfCity; idx++) {
			costs[idx] = scanner.nextInt();
		}
		int currentCost = Integer.MAX_VALUE;
		long answer = 0;
		for (int idx = 0; idx < countOfCity - 1; idx++) {
			int cost = costs[idx];
			currentCost = Math.min(cost, currentCost);
			answer += (long) currentCost * (long) needs[idx];
		}
		System.out.println(answer);
	}
}
