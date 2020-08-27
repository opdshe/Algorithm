package 백준.백트래킹;

import java.util.Scanner;

public class N과M {
	static int[] array;
	static boolean[] visited;
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();

		array = new int[M];
		visited = new boolean[N + 1];

		printComb(0);

	}

	private static void printComb(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[idx] = i;
				printComb(idx + 1);
				visited[i] = false;
			}
		}
	}
}
