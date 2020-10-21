package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 알지비거리2 {
	static Scanner scanner = new Scanner(System.in);
	static int size;

	public static void main(String[] args) {
		size = scanner.nextInt();
		int[][] costs = new int[size][3];
		for (int floor = 0; floor < size; floor++) {
			for (int rgb = 0; rgb < 3; rgb++) {
				costs[floor][rgb] = scanner.nextInt();
			}
		}
		solution(costs);
	}

	private static void solution(int[][] costs) {
		int[][] dp = new int[size][3];
		int INF = Integer.MAX_VALUE;
		for (int floor = 0; floor < size; floor++) {
			Arrays.fill(dp[floor], INF);
		}
		for (int rgb = 0; rgb < 3; rgb++) {
			dp[0][rgb] = costs[0][rgb];
		}
		for (int floor = 1; floor < size; floor++) {
			for (int pivot = 0; pivot < 3; pivot++) {
				for (int compare = 0; compare < 3; compare++) {
					if (pivot == compare) {
						continue;
					}
					dp[floor][pivot] = Math.min(dp[floor][pivot], dp[floor - 1][compare] + costs[floor][pivot]);
				}
			}
		}
		int answer = INF;
		for (int rgb = 0; rgb < 3; rgb++) {
			answer = Math.min(answer, dp[size - 1][rgb]);
		}
		System.out.println(answer);
	}
}
