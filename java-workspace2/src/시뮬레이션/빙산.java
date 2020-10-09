package 시뮬레이션;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class 빙산 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[][] map = new int[input[0]][input[1]];
		for (int row = 0; row < input[0]; row++) {
			map[row] = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		solution(map, input[0], input[1]);
	}

	private static void solution(int[][] map, int maxRow, int maxColumn) {
		int time = 0;
		while (isOneChunk(map, maxRow, maxColumn)) {
			int[][] removeMap = new int[maxRow][maxColumn];
			for (int row = 0; row < maxRow; row++) {
				for (int column = 0; column < maxColumn; column++) {
					int count = 0;
					for (int[] direction : directions) {
						int nextRow = row + direction[0];
						int nextColumn = column + direction[1];
						if (isAvailablePosition(maxRow, maxColumn, nextRow, nextColumn)) {
							if (map[nextRow][nextColumn] == 0) {
								count++;
							}
						}
					}
					removeMap[row][column] = count;
				}
			}

			int remain = 0;
			for (int row = 0; row < maxRow; row++) {
				for (int column = 0; column < maxColumn; column++) {
					map[row][column] -= removeMap[row][column];
					if (map[row][column] > 0) {
						remain++;
					} else {
						map[row][column] = 0;
					}
				}
			}
			if (remain == 0) {
				time = 0;
				break;
			}
			time++;
		}
		System.out.println(time);
	}

	private static boolean isOneChunk(int[][] map, int maxRow, int maxColumn) {
		boolean[][] visited = new boolean[maxRow][maxColumn];
		int count = 0;
		boolean result = true;
		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
				if (!visited[row][column] && map[row][column] > 0) {
					if (count > 0) {
						result = false;
						break;
					}
					connect(map, visited, maxRow, maxColumn, row, column);
					count++;
				}
			}
		}
		return result;
	}

	private static void connect(int[][] map, boolean[][] visited, int maxRow, int maxColumn, int row, int column) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[row][column] = true;
		queue.add(new int[]{row, column});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] direction : directions) {
				int nextRow = current[0] + direction[0];
				int nextColumn = current[1] + direction[1];
				if (isAvailablePosition(maxRow, maxColumn, nextRow, nextColumn)) {
					if (!visited[nextRow][nextColumn] && map[nextRow][nextColumn] > 0) {
						visited[nextRow][nextColumn] = true;
						queue.add(new int[]{nextRow, nextColumn});
					}
				}
			}
		}
	}


	private static boolean isAvailablePosition(int maxRow, int maxColumn, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}
}
