package 완전탐색.DFS;

import java.util.Arrays;
import java.util.Scanner;

public class 텀프로젝트 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int countOfPeople = scanner.nextInt();
			int[] isConnected = new int[countOfPeople + 1];
			boolean[] visited = new boolean[countOfPeople + 1];
			int[] pick = new int[countOfPeople + 1];
			for (int idx = 1; idx <= countOfPeople; idx++) {
				pick[idx] = scanner.nextInt();
				if (idx == pick[idx]) {
					isConnected[idx] = 1;
				}
			}

			for (int idx = 1; idx <= countOfPeople; idx++) {
				if (isConnected[idx] == 0) {
					System.out.println("start " + idx);
					visited = new boolean[countOfPeople + 1];
					connect(pick, isConnected, visited, idx, idx);
				}
			}

			int count = 0;
			for (int idx = 1; idx <= countOfPeople; idx++) {
				if (isConnected[idx] == -1) {
					count++;
				}
			}
			System.out.println(count);
			System.out.println(Arrays.toString(isConnected));
		}
	}

	private static int connect(int[] pick, int[] isConnected, boolean[] visited, int start, int node) {
		visited[node] = true;
		System.out.println("vissit" + node);
		int next = pick[node];
		int result;
		if (visited[next] || isConnected[next] == -1) {
			return -1;
		} else if (start == next) {
			isConnected[node] = 1;
			return isConnected[node];
		} else {
			result = connect(pick, isConnected, visited, start, next);
		}
		if (node == start) {
			return isConnected[node] = result;
		}
		return result;
	}
}
