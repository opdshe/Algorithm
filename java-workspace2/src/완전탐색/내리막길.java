package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 내리막길 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int maxRow;
	static int maxColumn;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		maxRow = input[0];
		maxColumn = input[1];
		int[][] map = new int[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			int[] line = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			for (int idx = 0; idx < maxColumn; idx++) {
				map[row][idx] = line[idx];
			}
		}
		int[][] visited = new int[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			Arrays.fill(visited[row], -1);
		}
		System.out.println(solution(map, visited, 0, 0));
	}

	private static int solution(int[][] map, int[][] visited, int currentRow, int currentColumn) {
		if (currentRow == maxRow - 1 && currentColumn == maxColumn - 1) {
			return 1;
		}
		if (visited[currentRow][currentColumn] != -1) {
			return visited[currentRow][currentColumn];
		}
		visited[currentRow][currentColumn] = 0;
		for (int[] direction : directions) {
			int nextRow = currentRow + direction[0];
			int nextColumn = currentColumn + direction[1];
			if (isAvailablePosition(nextRow, nextColumn)) {
				if (map[currentRow][currentColumn] > map[nextRow][nextColumn]) {
					visited[currentRow][currentColumn] += solution(map, visited, nextRow, nextColumn);
				}
			}
		}
		return visited[currentRow][currentColumn];
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}
}
