package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 인구이동 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int size;
	static int minDiff;
	static int maxDiff;
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
		size = input[0];
		minDiff = input[1];
		maxDiff = input[2];
		map = new int[size][size];
		for (int row = 0; row < size; row++) {
			map[row] = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		solution();
	}

	private static void solution() {
		int count = 0;
		while (true) {
			boolean[][] visited = new boolean[size][size];
			List<List<int[]>> chunk = new ArrayList<>();
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					if (!visited[row][column]) {
						List<int[]> entry = new ArrayList<>();
						entry.add(new int[]{row, column});
						connect(visited, entry, row, column);
						chunk.add(entry);
					}
				}
			}
			//국경 열린 경우
			if (chunk.size() != size * size) {
				count++;
				for (List<int[]> entry : chunk) {
					move(entry);
				}
			} else {
				break;
			}
		}
		System.out.println(count);
	}

	private static void move(List<int[]> entry) {
		int total = 0;
		for (int[] ints : entry) {
			total += map[ints[0]][ints[1]];
		}
		int countOfPeople = total / entry.size();
		for (int[] ints : entry) {
			map[ints[0]][ints[1]] = countOfPeople;
		}
	}

	private static void connect(boolean[][] visited, List<int[]> entry, int row, int column) {
		visited[row][column] = true;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn)) {
				int diff = Math.abs(map[row][column] - map[nextRow][nextColumn]);
				if (!visited[nextRow][nextColumn] && diff >= minDiff && diff <= maxDiff) {
					entry.add(new int[]{nextRow, nextColumn});
					connect(visited, entry, nextRow, nextColumn);
				}
			}
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
