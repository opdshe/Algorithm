package 완전탐색;

import java.util.Scanner;

public class 파이프옮기기1 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;
	static int count = 0;


	public static void main(String[] args) {
		size = scanner.nextInt();
		map = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		int result = dfs(0, 0, 1);
		System.out.println(result);
	}

	private static int dfs(int state, int row, int column) {
		if (row == size - 1 && column == size - 1) {
			return 1;
		}
		boolean availableToGoRight = column + 1 < size && map[row][column + 1] == 0;
		boolean availableToGoDown = row + 1 < size && map[row + 1][column] == 0;
		int total = 0;
		if (availableToGoRight && state != 1) {
			total += dfs(0, row, column + 1);
		}
		if (availableToGoDown && state != 0) {
			total += dfs(1, row + 1, column);
		}
		if (availableToGoRight && availableToGoDown && map[row + 1][column + 1] == 0) {
			total += dfs(2, row + 1, column + 1);
		}
		return total;
	}

}
