package 그래프.최단경로.플루이드와샬;

import java.util.Scanner;

public class 플루이드2 {
	static final int INF = Integer.MAX_VALUE;
	static Scanner scanner = new Scanner(System.in);
	static int[][] costs;

	public static void main(String[] args) {
		int countOfCity = scanner.nextInt();
		int countOfBus = scanner.nextInt();
		costs = new int[countOfCity + 1][countOfCity + 1];
		for (int row = 1; row <= countOfCity; row++) {
			for (int column = 1; column <= countOfCity; column++) {
				if (row == column) {
					costs[row][column] = 0;
				} else {
					costs[row][column] = INF;
				}
			}
		}
		for (int b = 0; b < countOfBus; b++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			costs[source][dest] = Math.min(costs[source][dest], cost);
		}
		floyd(countOfCity);
		for (int row = 1; row <= countOfCity; row++) {
			for (int column = 1; column <= countOfCity; column++) {
				System.out.print(costs[row][column] + " ");
			}
			System.out.println();
		}
	}

	private static void floyd(int countOfCity) {
		for (int mid = 1; mid <= countOfCity; mid++) {
			for (int row = 1; row <= countOfCity; row++) {
				for (int column = 1; column <= countOfCity; column++) {
					if (row == mid) {
						continue;
					}
					if (costs[row][mid] != INF && costs[mid][column] != INF) {
						int cost = costs[row][mid] + costs[mid][column];
						costs[row][column] = Math.min(costs[row][column], cost);
					}
				}
			}
		}
	}
}
