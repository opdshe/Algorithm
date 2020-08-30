package 백준.시뮬레이션;

import java.util.Scanner;

public class 영식이와친구들 {
	static int N;
	static int M;
	static int L;
	static int[] board;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		L = scanner.nextInt();

		board = new int[N + 1];
		int current = 1;
		board[current] = 1;

		int count = 0;
		while (true) {
			count++;
			int next;
			if (board[current] % 2 == 1) {
				next = (current + L) % N;
			} else {
				next = (current + (N + (L % N))) % N;
			}
			board[next]++;
			if (board[next] == M) {
				break;
			}
			current = next;
		}
		System.out.println(count);
	}

	private static boolean throwBall(int current) {
		int next;
		System.out.println("current " + current);
		if (board[current] % 2 == 1) {
			next = (current + L) % N;
		} else {
			next = (current + (N + (L % N))) % N;
		}
		board[next]++;
		if (board[next] == M) {
			return true;
		}
		return false;
	}
}
