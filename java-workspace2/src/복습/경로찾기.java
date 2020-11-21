package 복습;

import java.util.Scanner;

public class 경로찾기 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;

	public static void main(String[] args) {
		size = scanner.nextInt();
		map = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		solution();
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				System.out.print(map[row][column] + " ");
			}
			System.out.println();
		}
	}

	private static void solution() {
		for (int mid = 0; mid < size; mid++) {
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					if (row == mid) {
						continue;
					}
					if (map[row][mid] == 1 && map[mid][column] == 1) {
						map[row][column] = 1;
					}
				}
			}
		}
	}
}
