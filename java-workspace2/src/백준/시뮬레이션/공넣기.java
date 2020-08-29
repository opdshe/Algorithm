package 백준.시뮬레이션;

import java.util.Scanner;

public class 공넣기 {
	static int N;
	static int M;
	static int[] basket;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		basket = new int[N + 1];

		for (int i = 0; i < M; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			int ballNum = scanner.nextInt();
			throwBall(from, to, ballNum);
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(basket[i] + " ");
		}
	}

	private static void throwBall(int from, int to, int ballNum) {
		for (int i = from; i <= to; i++) {
			basket[i] = ballNum;
		}
	}
}
