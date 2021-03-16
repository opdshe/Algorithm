package 너비우선탐색;

import java.util.*;

public class 단지번호붙이기 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static List<Integer> answers = new ArrayList<>();


	public static void main(String[] args) {
		size = scanner.nextInt();
		map = new int[size][size];
		scanner.nextLine();
		for (int row = 0; row < size; row++) {
			map[row] = Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		boolean[][] visited = new boolean[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (!visited[row][column] && map[row][column] == 1) {
					int chunk = dfs(visited, row, column);
					answers.add(chunk);
				}
			}
		}
		answers.sort(Comparator.naturalOrder());
		System.out.println(answers.size());
		answers.forEach(System.out::println);
	}

	private static int dfs(boolean[][] visited, int row, int column) {
		visited[row][column] = true;
		int sum = 1;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailable(nextRow, nextColumn) && !visited[nextRow][nextColumn] &&
					map[nextRow][nextColumn] == 1) {
				sum += dfs(visited, nextRow, nextColumn);
			}
		}
		return sum;
	}

	private static boolean isAvailable(int row, int column) {
		return row >= 0 && row < size &&
				column >= 0 && column < size;
	}
}
