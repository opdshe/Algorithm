package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 빙산 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int maxRow;
	static int maxColumn;
	static int[][] map;
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
		maxRow = input[0];
		maxColumn = input[1];
		map = new int[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			int[] rowInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			for (int column = 0; column < maxColumn; column++) {
				map[row][column] = rowInfo[column];
			}
		}
		solution();
	}

	private static void solution() {
		int time = 0;
		while (true) {

		}
	}


	private static boolean isOneChunk(int row, int column) {
		return false;
	}

	private static void setRemoveSize() {

	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}
}
