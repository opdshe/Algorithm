package 그래프.위상정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 키순서 {
	static Scanner scanner = new Scanner(System.in);
	static int INF = 0xfffffff;

	public static void main(String[] args) {
		int countOfStudent = scanner.nextInt();
		int countOfOrder = scanner.nextInt();
		int[][] map = new int[countOfStudent + 1][countOfStudent + 1];
		for (int row = 1; row <= countOfStudent; row++) {
			for (int column = 1; column <= countOfStudent; column++) {
				if (row == column) {
					map[row][column] = 0;
				} else {
					map[row][column] = INF;
				}
			}
		}
		for (int idx = 0; idx < countOfOrder; idx++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			map[source][dest] = 1;
		}

		floyd(map, countOfStudent);

		boolean[] result = new boolean[countOfStudent + 1];
		Arrays.fill(result, true);
		int count = 0;
		for (int row = 1; row <= countOfStudent; row++) {
			for (int column = 1; column <= countOfStudent; column++) {
				if (row == column) {
					continue;
				}
				if (map[row][column] == INF && map[column][row] == INF) {
					result[row] = false;
					break;
				}
			}
		}
		for (int idx = 1; idx <= countOfStudent; idx++) {
			if (result[idx]) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static void floyd(int[][] map, int countOfStudent) {
		for (int mid = 1; mid <= countOfStudent; mid++) {
			for (int row = 1; row <= countOfStudent; row++) {
				for (int column = 1; column <= countOfStudent; column++) {
					if (mid == row) {
						continue;
					}
					int cost = map[row][mid] + map[mid][column];
					if (map[row][column] > cost) {
						map[row][column] = cost;
					}
				}
			}
		}
	}
}
