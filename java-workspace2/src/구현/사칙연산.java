package 구현;

import java.util.Scanner;

public class 사칙연산 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		scanner.nextLine();
		for (int test = 0; test < testcase; test++) {
			String[] order = scanner.nextLine().split(" ");
			long resultOfCalculation = calculate(Long.parseLong(order[0]), Long.parseLong(order[2]), order[1]);
			System.out.println(resultOfCalculation == Long.parseLong(order[4]) ? "correct" : "wrong answer");
		}
	}

	private static long calculate(long a, long b, String operator) {
		switch (operator) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			default:
				return a / b;
		}
	}
}
