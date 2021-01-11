package 구현;

import java.util.Scanner;

public class 연산자끼워넣기 {
	static Scanner scanner = new Scanner(System.in);
	static int countOfNumber;
	static int[] numbers;
	static int[] countOfOperators = new int[4]; //0 : 더하기, 1: 빼기, 2: 곱하기, 3: 나누기
	static int maxValue = Integer.MIN_VALUE;
	static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) {
		countOfNumber = scanner.nextInt();
		numbers = new int[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		for (int idx = 0; idx < 4; idx++) {
			countOfOperators[idx] = scanner.nextInt();
		}
		dfs(0, numbers[0]);
		System.out.println(maxValue);
		System.out.println(minValue);
	}

	private static void dfs(int operatorIdx, int sum) {
		if (operatorIdx == countOfNumber - 1) {
			minValue = Math.min(minValue, sum);
			maxValue = Math.max(maxValue, sum);
			return;
		}
		for (int operator = 0; operator < 4; operator++) {
			int countOfOperator = countOfOperators[operator];
			if (countOfOperator > 0) {
				countOfOperators[operator]--;
				int target = numbers[operatorIdx + 1];
				dfs(operatorIdx + 1, calculate(operator, sum, target));
				countOfOperators[operator]++;
			}
		}
	}

	private static int calculate(int operator, int a, int b) {
		if (operator == 0) {
			return a + b;
		} else if (operator == 1) {
			return a - b;
		} else if (operator == 2) {
			return a * b;
		} else {
			return a / b;
		}
	}
}
