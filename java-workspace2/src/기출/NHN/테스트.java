package 기출.NHN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 테스트 {
	public static void main(String[] args) {
		solution(3, new int[][]{
				{1, 1, 0},
				{0, 0, 1},
				{0, 0, 1}
		});
	}

	private static int size;
	private static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	private static void solution(int sizeOfMatrix, int[][] matrix) {
		size = sizeOfMatrix;
		List<Integer> answer = new ArrayList<>();
		boolean[][] visited = new boolean[sizeOfMatrix][sizeOfMatrix];
		for (int row = 0; row < sizeOfMatrix; row++) {
			for (int column = 0; column < sizeOfMatrix; column++) {
				if (!visited[row][column] && matrix[row][column] == 1) {
					answer.add(dfs(matrix, visited, row, column));
				}
			}
		}
		answer.sort(Comparator.naturalOrder());
		System.out.println(answer.size());
		for (Integer integer : answer) {
			System.out.print(integer + " ");
		}
	}

	private static int dfs(int[][] matrix, boolean[][] visited, int row, int column) {
		visited[row][column] = true;
		int sum = 1;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn)) {
				if (!visited[nextRow][nextColumn] && matrix[nextRow][nextColumn] == 1) {
					sum += dfs(matrix, visited, nextRow, nextColumn);
				}
			}
		}
		return sum;
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
