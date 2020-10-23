package 분류안함;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class 연산자끼워넣기 {
	static Scanner scanner = new Scanner(System.in);
	//+ , - , * , /순
	static int[] operators = new int[4];
	static int[] operatorIdx;
	static int minValue = Integer.MAX_VALUE;
	static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		operatorIdx = new int[countOfNumber - 1];
		int[] numbers = new int[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		for (int idx = 0; idx < 4; idx++) {
			operators[idx] = scanner.nextInt();
		}
		dfs(countOfNumber, numbers, 0);
		System.out.println(maxValue);
		System.out.println(minValue);
	}

	private static void dfs(int countOfNumber, int[] numbers, int level) {
		if (level == countOfNumber) {
			int calculatedValue = getCalculatedValue(numbers);
			minValue = Math.min(minValue, calculatedValue);
			maxValue = Math.max(maxValue, calculatedValue);
			return;
		}
		for (int idx = 0; idx < 4; idx++) {
			if (operators[idx] > 0) {
				operatorIdx[level] = idx;
				operators[idx]--;
				dfs(countOfNumber, numbers, level + 1);
				operators[idx]++;
			}
		}
	}

	private static int getCalculatedValue(int[] numbers) {
		Deque<Integer> numberQueue = new ArrayDeque<>();
		Queue<Integer> operatorQueue = new ArrayDeque<>();
		for (int number : numbers) {
			numberQueue.add(number);
		}
		for (int operator : operatorIdx) {
			operatorQueue.add(operator);
		}
		for (int i = 0; i < numbers.length - 1; i++) {
			int a = numberQueue.pollFirst();
			int b = numberQueue.pollFirst();
			int operator = operatorQueue.poll();
			numberQueue.addFirst(calculate(a, b, operator));
		}
		return numberQueue.getFirst();
	}

	private static int calculate(int a, int b, int operator) {
		if (operator == 0) {
			return a + b;
		} else if (operator == 1) {
			return a - b;
		} else if (operator == 2) {
			return a * b;
		}
		return a / b;
	}
}
