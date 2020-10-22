package 완전탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 스도쿠 {
	static Scanner scanner = new Scanner(System.in);
	static int[][] board = new int[9][9];
	static List<int[]> blanks = new ArrayList<>();
	static int[][] answer = null;

	public static void main(String[] args) {
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				int value = scanner.nextInt();
				board[row][column] = value;
				if (value == 0) {
					blanks.add(new int[]{row, column});
				}
			}
		}
		dfs(0);
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				System.out.print(answer[row][column] + " ");
			}
			System.out.println();
		}
	}

	private static void dfs(int level) {
		if (level == blanks.size()) {
			answer = deepCopy(board);
			return;
		}
		int[] current = blanks.get(level);
		for (int target = 1; target < 10; target++) {
			boolean result = true;
			result &= isAvailableRow(current[0], current[1], target);
			result &= isAvailableColumn(current[0], current[1], target);
			result &= isAvailableSquare(current[0], current[1], target);
			if (result) {
				board[current[0]][current[1]] = target;
				dfs(level + 1);
				board[current[0]][current[1]] = 0;
			}
		}
	}

	private static boolean isAvailableSquare(int row, int column, int target) {
		int startRow = (row / 3) * 3;
		int startColumn = (column / 3) * 3;
		boolean isOkay = true;
		for (int r = startRow; r < startRow + 3; r++) {
			for (int c = startColumn; c < startColumn + 3; c++) {
				if (board[r][c] == target) {
					isOkay = false;
					break;
				}
			}
		}
		return isOkay;
	}

	private static boolean isAvailableRow(int row, int column, int target) {
		boolean isOkay = true;
		for (int r = 0; r < 9; r++) {
			if (board[r][column] == target) {
				isOkay = false;
				break;
			}
		}
		return isOkay;
	}

	private static boolean isAvailableColumn(int row, int column, int target) {
		boolean isOkay = true;
		for (int c = 0; c < 9; c++) {
			if (board[row][c] == target) {
				isOkay = false;
				break;
			}
		}
		return isOkay;
	}

	private static int[][] deepCopy(int[][] origin) {
		if (origin == null) return null;
		int[][] result = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
		}
		return result;
	}
}
