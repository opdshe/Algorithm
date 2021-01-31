package 그래프.최단경로.플루이드와샬;

import java.util.Scanner;

public class 경로찾기2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int[][] map = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		floyd(map, size);
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				System.out.print(map[row][column] + " ");
			}
			System.out.println();
		}
	}

	private static void floyd(int[][] map, int size) {
		for (int mid = 0; mid < size; mid++) {
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					if (mid == row) {
						continue;
					}
					if (map[row][column] == 0 && map[row][mid] == 1 && map[mid][column] == 1) {
						map[row][column] = 1;
					}
				}
			}
		}
	}
}
