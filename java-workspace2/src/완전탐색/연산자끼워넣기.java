package 완전탐색;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 연산자끼워넣기 {
	static int[] array;
	static Scanner scanner = new Scanner(System.in);
	static String[] operators = new String[]{"+", "-", "*", "/"};
	static int max = -2000000000;
	static int min = 2000000000;

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int[] numbers = new int[N];
		for (int idx = 0; idx < N; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		int[] countOfOperator = new int[4];
		array = new int[N - 1];
		for (int idx = 0; idx < 4; idx++) {
			countOfOperator[idx] = scanner.nextInt();
		}
		dfs(numbers, countOfOperator, N, 0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int[] numbers, int[] countOfOperator, int N, int count) {
		if (count == N - 1) {
			List<Integer> numList = Arrays.stream(numbers).
					boxed()
					.collect(Collectors.toList());
			int value = operate(numList, N);
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		for (int idx = 0; idx < 4; idx++) {
			if (countOfOperator[idx] > 0) {
				countOfOperator[idx]--;
				array[count] = idx;
				dfs(numbers, countOfOperator, N, count + 1);
				countOfOperator[idx]++;
			}
		}
	}

	private static int operate(List<Integer> number, int N) {
		for (int idx = 0; idx < array.length; idx++) {
			calculate(number, operators[array[idx]]);
		}
		return number.get(0);
	}

	private static void calculate(List<Integer> numList, String operator) {
		int first = numList.remove(0);
		int second = numList.remove(0);
		if (operator.equals("+")) {
			numList.add(0, first + second);
		} else if (operator.equals("-")) {
			numList.add(0, first - second);
		} else if (operator.equals("*")) {
			numList.add(0, first * second);
		} else {
			numList.add(0, first / second);
		}
	}
}
