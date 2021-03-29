package 시뮬레이션;

import java.util.Scanner;

public class 뱀 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;


	public static void main(String[] args) {
		size = scanner.nextInt();
		int countOfApple = scanner.nextInt();
		map = new int[size][size];
		for (int i = 0; i < countOfApple; i++) {
			int row = scanner.nextInt();
			int column = scanner.nextInt();
			map[row][column] = scanner.nextInt();
		}
		int change = scanner.nextInt();
		for (int c = 0; c < change; c++) {
				
		}
	}
}
