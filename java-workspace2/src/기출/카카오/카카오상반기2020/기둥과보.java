package 기출.카카오.카카오상반기2020;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기둥과보 {
	static int N;
	static boolean[][] columns;
	static boolean[][] carpets;
	static List<int[]> answer = new ArrayList<>();

	public static void main(String[] args) {
		solution(5, new int[][]
				{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1},
						{2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}}
		);
	}

	public static int[][] solution(int n, int[][] build_frame) {
		int size = n;
		columns = new boolean[size + 3][size + 3];
		carpets = new boolean[size + 3][size + 3];
		for (int[] order : build_frame) {
			order[0]++;
			order[1]++;
			operate(order);
		}

		for (int i = 0; i <= size + 2; i++) {
			for (int j = 0; j <= size + 2; j++) {
				if (columns[j][i]) {
					answer.add(new int[]{i - 1, j - 1, 0});
				}
				if (carpets[j][i]) {
					answer.add(new int[]{i - 1, j - 1, 1});
				}
			}
		}
		for (int[] ints : answer) {
			System.out.println(Arrays.toString(ints));
		}
		return answer.toArray(new int[answer.size()][]);
	}

	private static void operate(int[] order) {
		if (order[3] == 0) {
			//기둥삭제
			if (order[2] == 0) {
				deleteColumn(order);
			} else {
				deleteCarpet(order);
			}
		} else {
			//기둥설치
			if (order[2] == 0) {
				createColumn(order);
			} else {
				createCarpet(order);
			}
		}
	}

	private static void deleteColumn(int[] order) {
		if (!columns[order[1]][order[0]]) {
			return;
		}
		columns[order[1]][order[0]] = false;
		if (!(isAvailableColumn(order[1] + 1, order[0]) &&
				isAvailableCarpet(order[1], order[0] - 1) && isAvailableCarpet(order[1], order[0]))) {
			columns[order[1]][order[0]] = true;
		}
	}

	private static void deleteCarpet(int[] order) {
		if (!carpets[order[1]][order[0]]) {
			return;
		}
		carpets[order[1]][order[0]] = false;
		if (!(isAvailableCarpet(order[1], order[0] - 1) && isAvailableCarpet(order[1], order[0] + 1) &&
				isAvailableColumn(order[1], order[0]) && isAvailableColumn(order[1], order[0] + 1))) {
			carpets[order[1]][order[0]] = true;
		}
	}

	private static void createColumn(int[] order) {
		if (isAvailableColumn(order[1], order[0])) {
			columns[order[1]][order[0]] = true;
		}
	}

	private static void createCarpet(int[] order) {
		if (isAvailableCarpet(order[1], order[0])) {
			carpets[order[1]][order[0]] = true;
		}
	}

	private static boolean isAvailableColumn(int height, int width) {
		return height == 1 || carpets[height][width - 1] || carpets[height][width] ||
				columns[height - 1][width];
	}

	private static boolean isAvailableCarpet(int height, int width) {
		return columns[height - 1][width] || columns[height - 1][width + 1] ||
				(carpets[height][width - 1] && carpets[height][width + 1]);
	}
}