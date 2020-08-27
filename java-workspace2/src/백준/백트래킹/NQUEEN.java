package 백준.백트래킹;

import java.util.Scanner;

public class NQUEEN {
	static int N;
	static int answer = 0;
	static int[] position;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		position = new int[N];
		backTracking(0);
		System.out.println(answer);
	}

	private static void backTracking(int level) {
		if (level == N) {
			answer++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isAvailablePosition(level, i)) {
				position[level] = i;
				backTracking(level + 1);
			}
		}

	}

	private static boolean isAvailablePosition(int level, int idx) {
		if (level == 0) {
			return true;
		}
		for (int i = 0; i < level; i++) {
			if (position[i] == idx) {
				return false;
			}
			if (Math.abs(position[i] - idx) == Math.abs(i - level)) {
				return false;
			}
		}

		return true;
	}
}
