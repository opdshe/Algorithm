package 분류안함;

import java.util.Scanner;

public class 팀프로젝트 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int countOfStudent = scanner.nextInt();
			int[] pick = new int[countOfStudent + 1];
			boolean[] visited = new boolean[countOfStudent + 1];
			boolean[] connected = new boolean[countOfStudent + 1];
			for (int idx = 1; idx <= countOfStudent; idx++) {
				pick[idx] = scanner.nextInt();
				if (idx == pick[idx]) {
					connected[idx] = true;
				}
			}
			solution(pick, connected, visited, countOfStudent);
			int count = 0;
			for (int idx = 1; idx <= countOfStudent; idx++) {
				if (!connected[idx]) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	private static void solution(int[] pick, boolean[] connected, boolean[] visited, int countOfStudent) {
		connect(pick, connected, visited, 1, 1, 0);
		for (int idx = 1; idx <= countOfStudent; idx++) {
			if (!visited[idx]) {
				connect(pick, connected, visited, idx, idx, 0);
			}
		}
	}

	private static boolean connect(int[] pick, boolean[] connected, boolean[] visited, int start, int current, int count) {
		visited[current] = true;
		if (connected[current]) {
			return false;
		}
		if (current == start && count > 0) {
			//visited[current] = true;
			return true;
		}
		boolean result = connect(pick, connected, visited, start, pick[current], count + 1);
		connected[current] = result;
		return result;
	}
}
