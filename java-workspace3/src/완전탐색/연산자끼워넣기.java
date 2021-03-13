package 완전탐색;

import java.util.Scanner;

public class 연산자끼워넣기 {
	static Scanner scanner = new Scanner(System.in);
	static int[] operators = new int[4]; // 0: + , 1 : -, 2: +, 3 : /
	static int[] operatorIdx;
	static int[] numbers;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		numbers = new int[countOfNumber];
		operatorIdx = new int[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		for (int idx = 0; idx < 4; idx++) {
			operators[idx] = scanner.nextInt();
		}
		dfs(countOfNumber, 0, numbers[0]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int countOfNumber, int level, int current) {
		if (level == countOfNumber - 1) {
			min = Math.min(min, current);
			max = Math.max(max, current);
			return;
		}
		for (int idx = 0; idx < 4; idx++) {
			if (operators[idx] > 0) {
				operators[idx]--;
				int next = calculate(idx, current, numbers[level + 1]);
				dfs(countOfNumber, level + 1, next);
				operators[idx]++;
			}
		}
	}

	private static int calculate(int operatorIdx, int a, int b) {
		if (operatorIdx == 0) {
			return a + b;
		} else if (operatorIdx == 1) {
			return a - b;
		} else if (operatorIdx == 2) {
			return a * b;
		}
		return a / b;
	}
}
