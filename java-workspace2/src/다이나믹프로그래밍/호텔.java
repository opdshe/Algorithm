package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 호텔 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int countOfCity = scanner.nextInt();
		int[] costs = new int[1001];
		int INF = 0xfffffff;
		Arrays.fill(costs, INF);
		costs[0] = 0;

		for (int city = 0; city < countOfCity; city++) {
			int cost = scanner.nextInt();
			int people = scanner.nextInt();
			for (int num = 1; num * people <= 1000; num++) {
				int current = people * num;
				if (costs[current - people] != INF) {
					costs[current] = Math.min(costs[current], costs[current - people] + cost);
				}
			}
		}
		System.out.println(Arrays.toString(costs));
		int answer = INF;
		for (int people = target; people <= 1000; people++) {
			if (costs[people] != INF) {
				answer = Math.min(answer, costs[people]);
			}
		}
		System.out.println(answer);
	}
}
