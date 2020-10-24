package 기출.NHN;

import java.util.*;

public class 테스트 {
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	private static void solution(int sizeOfMatrix, int[][] matrix) {
		boolean[][] visited = new boolean[sizeOfMatrix][sizeOfMatrix];
		List<Integer> answer = new ArrayList<>();
		for (int row = 0; row < sizeOfMatrix; row++) {
			for (int column = 0; column < sizeOfMatrix; column++) {
				if (!visited[row][column] && matrix[row][column] == 1) {
					answer.add(dfs(visited, matrix, sizeOfMatrix, row, column));
				}
			}
		}
		answer.sort(Comparator.naturalOrder());
		System.out.println(answer.size());
		for (Integer integer : answer) {
			System.out.print(integer + " ");
		}
	}

	private static int dfs(boolean[][] visited, int[][] matrix, int matrixSize, int row, int column) {
		visited[row][column] = true;
		int sum = 1;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(matrixSize, nextRow, nextColumn)) {
				if (!visited[nextRow][nextColumn] && matrix[nextRow][nextColumn] == 1) {
					sum += dfs(visited, matrix, matrixSize, nextRow, nextColumn);
				}
			}
		}
		return sum;
	}

	private static boolean isAvailablePosition(int matrixSize, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < matrixSize &&
				nextColumn >= 0 && nextColumn < matrixSize;
	}

	private static class InputData {
		int sizeOfMatrix;
		int[][] matrix;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
			for (int i = 0; i < inputData.sizeOfMatrix; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.sizeOfMatrix; j++) {
					inputData.matrix[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.sizeOfMatrix, inputData.matrix);
	}
}
