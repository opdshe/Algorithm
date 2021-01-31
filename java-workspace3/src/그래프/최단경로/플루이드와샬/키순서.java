package 그래프.최단경로.플루이드와샬;

import java.util.Scanner;

public class 키순서 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfStudent = scanner.nextInt();
		int countOfInfo = scanner.nextInt();
		int[][] map = new int[countOfStudent + 1][countOfStudent + 1];
		int answer = 0;

		for (int i = 0; i < countOfInfo; i++) {
			int smaller = scanner.nextInt();
			int taller = scanner.nextInt();
			map[smaller][taller] = 1;
		}
		floyd(map, countOfStudent);

		for (int student = 1; student <= countOfStudent; student++) {
			int smaller = 0;
			int taller = 0;
			for (int compare = 1; compare <= countOfStudent; compare++) {
				if (map[compare][student] == 1) {
					smaller++;
				} else if (map[student][compare] == 1) {
					taller++;
				}
			}
			if (smaller + taller == countOfStudent - 1) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void floyd(int[][] map, int countOfStudent) {
		for (int mid = 1; mid <= countOfStudent; mid++) {
			for (int row = 1; row <= countOfStudent; row++) {
				for (int column = 1; column <= countOfStudent; column++) {
					if (mid == row) {
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
