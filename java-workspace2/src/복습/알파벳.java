package 복습;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 알파벳 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;
	static char[][] board;
	static boolean[] visited = new boolean[26];
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		board = new char[maxRow][maxColumn];
		scanner.nextLine();
		for (int row = 0; row < maxRow; row++) {
			board[row] = scanner.nextLine().toCharArray();
		}
		int answer = getMaxDistance(0, 0);
		System.out.println(answer);
	}

	private static int getMaxDistance(int row, int column) {
		char alpha = board[row][column];
		visited[(int) alpha - 65] = true;
		int base = 1;
		int add = 0;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn)) {
				char nextAlpha = board[nextRow][nextColumn];
				if (!visited[(int) nextAlpha - 65]) {
					visited[(int) nextAlpha - 65] = true;
					add = Math.max(add, getMaxDistance(nextRow, nextColumn));
					visited[(int) nextAlpha - 65] = false;
				}
			}
		}
		return base + add;
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}
}
