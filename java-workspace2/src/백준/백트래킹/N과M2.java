package 백준.백트래킹;

import java.util.Scanner;

public class N과M2 {
	static int N;
	static int M;
	static int[] array;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		visited = new boolean[N + 1];
		array = new int[M];

		backTracking(1, 0);

	}

	private static void backTracking(int start, int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[count] = i;
				backTracking(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}
}
