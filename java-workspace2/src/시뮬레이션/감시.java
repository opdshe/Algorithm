package 시뮬레이션;

import java.util.Scanner;

public class 감시 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;
	static int[][] map;

	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		map = new int[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
				int value = scanner.nextInt();
				map[row][column] = value;
			}
		}
	}
}
