package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 인구이동 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int leftDiff;
	static int rightDiff;
	static City[][] map;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		size = scanner.nextInt();
		leftDiff = scanner.nextInt();
		rightDiff = scanner.nextInt();
		map = new City[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = new City(scanner.nextInt());
			}
		}

		int answer = 0;
		while (true) {
			boolean isChange = false;
			boolean[][] visited = new boolean[size][size];
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					if (!visited[row][column]) {
						List<City> cities = new ArrayList<>();
						int sum = dfs(visited, cities, row, column);
						cities.forEach(city -> city.people = sum / cities.size());
						if (cities.size() > 1) {
							isChange = true;
						}
					}
				}
			}
			if (!isChange) {
				break;
			}
			answer++;
		}
		System.out.println(answer);
	}

	private static int dfs(boolean[][] visited, List<City> cities, int row, int column) {
		visited[row][column] = true;
		City city = map[row][column];
		cities.add(city);
		int sum = city.people;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn) && !visited[nextRow][nextColumn]) {
				City nextCity = map[nextRow][nextColumn];
				int diff = Math.abs(city.people - nextCity.people);
				if (diff >= leftDiff && diff <= rightDiff) {
					sum += dfs(visited, cities, nextRow, nextColumn);
				}
			}
		}
		return sum;
	}

	private static boolean isAvailablePosition(int row, int column) {
		return row >= 0 && row < size &&
				column >= 0 && column < size;
	}

	private static class City {
		private int people;

		public City(int people) {
			this.people = people;
		}
	}
}
