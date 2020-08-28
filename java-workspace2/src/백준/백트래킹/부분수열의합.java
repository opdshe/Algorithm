package 백준.백트래킹;

import java.util.Scanner;

public class 부분수열의합 {
	static int N;
	static int target;
	static int[] numbers;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		target = scanner.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scanner.nextInt();
		}
		visited = new boolean[N];
		backTracking(0, 0);
		if (target == 0) {
			answer--;
		}
		System.out.println(answer);
	}

	private static void backTracking(int level, int sum) {
		if (sum == target) {
			answer++;
		}
		for (int i = level; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backTracking(i + 1, sum + numbers[i]);
				visited[i] = false;
			}
		}

	}
}
