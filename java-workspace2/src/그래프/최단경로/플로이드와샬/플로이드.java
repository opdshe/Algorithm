package 그래프.최단경로.플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 플로이드 {
	static int INF = 100001;
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfCity = Integer.parseInt(bufferedReader.readLine());
		int countOfBus = Integer.parseInt(bufferedReader.readLine());
		int[][] cities = new int[countOfCity + 1][countOfCity + 1];
		for (int row = 1; row <= countOfCity; row++) {
			for (int column = 1; column <= countOfCity; column++) {
				if (row != column) {
					cities[row][column] = INF;
				}
			}
		}

		for (int bus = 0; bus < countOfBus; bus++) {
			int[] busInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			cities[busInfo[0]][busInfo[1]] = Math.min(cities[busInfo[0]][busInfo[1]], busInfo[2]);
		}
		floyd(cities, countOfCity);
		for (int row = 1; row <= countOfCity; row++) {
			for (int column = 1; column <= countOfCity; column++) {
				System.out.print(cities[row][column] == INF ? 0 : cities[row][column]);
				System.out.print(" ");
			}
			System.out.println();

		}
	}

	private static void floyd(int[][] cities, int countOfCity) {
		for (int mid = 1; mid <= countOfCity; mid++) {
			for (int row = 1; row <= countOfCity; row++) {
				for (int column = 1; column <= countOfCity; column++) {
					if (row == mid) {
						continue;
					}
					int cost = cities[row][mid] + cities[mid][column];
					if (cities[row][column] > cost) {
						cities[row][column] = cost;
					}
				}
			}
		}
	}
}
