package 완전탐색.백트래킹;

import java.util.Scanner;

public class NQUEEN {
	static int answer = 0;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int[] columns = new int[N];
		solution(columns, N, 0);
		System.out.println(answer);
	}

	private static void solution(int[] columns, int N, int level) {
		if (level == N) {
			answer++;
			return;
		}
		for (int column = 0; column < N; column++) {
			if (isAvailable(columns, level, column)) {
				columns[level] = column;
				solution(columns, N, level + 1);
			}
		}
	}

	private static boolean isAvailable(int[] columns, int level, int column) {
		for (int row = 0; row < level; row++) {
			if (columns[row] == column) {
				return false;
			}
			if (Math.abs(level - row) == Math.abs(column - columns[row])) {
				return false;
			}
		}
		return true;
	}
}
