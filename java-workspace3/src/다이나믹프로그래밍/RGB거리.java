package 다이나믹프로그래밍;

import java.util.Scanner;

public class RGB거리 {
	static Scanner scanner = new Scanner(System.in);
	static int[][] costs;

	public static void main(String[] args) {
		int countOfHouse = scanner.nextInt();
		costs = new int[countOfHouse][4];
		for (int house = 0; house < countOfHouse; house++) {
			for (int color = 1; color <= 3; color++) {
				costs[house][color] = scanner.nextInt();
			}
		}
		int answer = solution(countOfHouse);
		System.out.println(answer);
	}

	private static int solution(int countOfHouse) {
		int[][] dp = new int[countOfHouse][5];
		int INF = Integer.MAX_VALUE;
		int answer = INF;
		for (int house = 0; house < countOfHouse; house++) {
			for (int color = 1; color <= 3; color++) {
				dp[house][color] = INF;
			}
		}
		for (int color = 1; color <= 3; color++) {
			dp[0][color] = costs[0][color];
		}
		for (int house = 1; house < countOfHouse; house++) {
			for (int pivot = 1; pivot <= 3; pivot++) {
				for (int compare = 1; compare <= 3; compare++) {
					if (pivot == compare) {
						continue;
					}
					dp[house][pivot] = Math.min(dp[house][pivot], dp[house - 1][compare] + costs[house][pivot]);
				}
			}
		}
		for (int color = 1; color <= 3; color++) {
			answer = Math.min(dp[countOfHouse - 1][color], answer);
		}
		return answer;
	}
}
