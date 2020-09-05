package 백준.백트래킹;

import java.util.Scanner;

public class 연산자끼워넣기 {
	static int max = -1000000000;
	static int min = 1000000000;
	static int[] numbers;
	static int[] operators;
	static int N;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scanner.nextInt();
		}
		operators = new int[4];
		for (int i = 0; i < 4; i++) {
			operators[i] = scanner.nextInt();
		}
		solve(0, numbers[0]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void solve(int idx, int current) {
		if (idx == N - 1) {
			min = Math.min(min, current);
			max = Math.max(max, current);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				int nextValue = nextValue(i, current, numbers[idx + 1]);
				operators[i]--;
				solve(idx + 1, nextValue);
				operators[i]++;
			}
		}
	}

	private static int nextValue(int operator, int current, int operand) {
		if (operator == 0) {
			return current + operand;
		}
		if (operator == 1) {
			return current - operand;
		}
		if (operator == 2) {
			return current * operand;
		}
		return current / operand;
	}
}
