package 카카오상반기2020;

import java.util.Arrays;

public class 기둥과보 {
	static int N;
	static boolean[][] columns;
	static boolean[][] carpets;

	public static void main(String[] args) {
		solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
	}

	public static int[][] solution(int n, int[][] build_frame) {
		N = n;
		columns = new boolean[N + 1][N + 1];
		carpets = new boolean[N + 1][N + 1];
		for (int[] info : build_frame) {
			int[] position = convertKakaoToOrigin(info[0], info[1]);
			operate(position, info[2], info[3]);
		}
		for (int i = 0; i < columns.length; i++) {
			System.out.println(Arrays.toString(columns[i]));
		}
		System.out.println();
		for (int i = 0; i < columns.length; i++) {
			System.out.println(Arrays.toString(carpets[i]));
		}
		return null;
	}

	private static void operate(int[] position, int target, int order) {
		//target 0 = 기둥 , 1 = 보
		if (target == 0) {
			if (order == 1) {
				createColumn(position);
			} else {
				deleteColumn(position);
			}
		} else {
			if (order == 1) {
				createCarpet(position);
			} else {
				deleteCarpet(position);
			}
		}
	}

	private static void deleteCarpet(int[] position) {
		if (checkColumn(new int[]{position[0], position[1]}) &&
				checkColumn(new int[]{position[0], position[1] + 1}) &&
				checkCarpet(new int[]{position[0], position[1] - 1}) &&
				checkCarpet(new int[]{position[0], position[1] + 1})) {
			carpets[position[0]][position[1]] = false;
		}
	}

	private static void deleteColumn(int[] position) {
		if (checkColumn(new int[]{position[0] - 1, position[1]}) &&
				checkCarpet(new int[]{position[0] + 1, position[1] - 1}) &&
				checkCarpet(new int[]{position[0] + 1, position[1]})
		) {
			columns[position[0]][position[1]] = false;
		}
	}


	private static void createCarpet(int[] position) {
		if (checkCarpet(position)) {
			System.out.println("crate cartet " + Arrays.toString(position));
			carpets[position[0]][position[1]] = true;
		}
	}

	private static void createColumn(int[] position) {
		if (checkColumn(position)) {
			System.out.println("crate column " + Arrays.toString(position));
			columns[position[0]][position[1]] = true;
		}
	}

	private static boolean checkCarpet(int[] position) {
		return columns[position[0]][position[1]] || columns[position[0]][position[1] + 1] ||
				carpets[position[0]][position[1] - 1] && carpets[position[0]][position[1] + 1];
	}

	private static boolean checkColumn(int[] position) {
		return position[0] == N || carpets[position[0]][position[1] - 1] ||
				columns[position[0]][position[1] + 1];
	}

	private static int[] convertKakaoToOrigin(int x, int y) {
		return new int[]{N - y, x};
	}

	private static int[] convertOriginToKakao(int[] position) {
		return new int[]{position[1], N - position[0]};
	}
}