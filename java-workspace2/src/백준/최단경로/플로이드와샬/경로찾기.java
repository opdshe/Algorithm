package 백준.최단경로.플로이드와샬;

import java.util.Scanner;

public class 경로찾기 {
	static Scanner scanner = new Scanner(System.in);
	static int[][] adj;
	static int N;

	public static void main(String[] args) {
		N = scanner.nextInt();
		adj = new int[N][N];
		for (int height = 0; height < N; height++) {
			for (int width = 0; width < N; width++) {
				adj[height][width] = scanner.nextInt();
			}
		}

		floyd(adj);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void floyd(int[][] adj) {
		for (int midNode = 0; midNode < N; midNode++) {
			for (int height = 0; height < N; height++) {
				for (int width = 0; width < N; width++) {
					if (height == midNode) {
						continue;
					}
					if (adj[height][midNode] == 1 && adj[midNode][width] == 1) {
						adj[height][width] = 1;
					}
				}
			}
		}
	}

}
