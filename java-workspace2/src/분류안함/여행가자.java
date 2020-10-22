package 분류안함;

import java.util.Scanner;

public class 여행가자 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int countOfTravel = scanner.nextInt();
		int[][] map = new int[size + 1][size + 1];
		for (int row = 1; row <= size; row++) {
			for (int column = 1; column <= size; column++) {
				map[row][column] = scanner.nextInt();
				//자기자신으로 가는 건 항상 1
				if (row == column) {
					map[row][column] = 1;
				}
			}
		}
		int[] travel = new int[countOfTravel];
		for (int idx = 0; idx < countOfTravel; idx++) {
			travel[idx] = scanner.nextInt();
		}
		floyd(map, size);
		boolean isOkay = true;
		for (int start = 0; start < countOfTravel - 1; start++) {
			if (map[travel[start]][travel[start + 1]] == 0) {
				isOkay = false;
			}
		}
		System.out.println(isOkay ? "YES" : "NO");
	}

	private static void floyd(int[][] map, int size) {
		for (int mid = 1; mid <= size; mid++) {
			for (int row = 1; row <= size; row++) {
				for (int column = 1; column <= size; column++) {
					if (mid != row) {
						if (map[row][mid] == 1 && map[mid][column] == 1) {
							map[row][column] = 1;
						}
					}
				}
			}
		}
	}
}
