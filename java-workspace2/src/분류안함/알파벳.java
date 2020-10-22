package 분류안함;

import java.util.*;

public class 알파벳 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;
	static char[][] map;
	static Set<Character> charSet = new HashSet<>();
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int answer = 0;

	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		map = new char[maxRow][maxColumn];
		scanner.nextLine();
		for (int row = 0; row < maxRow; row++) {
			map[row] = scanner.nextLine().toCharArray();
		}
		dfs(0, 0, 1);
		System.out.println(answer);
	}

	private static void dfs(int row, int column, int distance) {
		answer = Math.max(answer, distance);
		charSet.add(map[row][column]);
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn)) {
				if (!charSet.contains(map[nextRow][nextColumn])) {
					charSet.add(map[nextRow][nextColumn]);
					dfs(nextRow, nextColumn, distance + 1);
					charSet.remove(map[nextRow][nextColumn]);
				}
			}
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}
}
