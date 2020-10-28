package 스택큐;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class 후위표기식2 {
	static Scanner scanner = new Scanner(System.in);
	static HashMap<Character, Integer> alphas = new HashMap<>();

	public static void main(String[] args) {
		int countOfAlpha = scanner.nextInt();
		scanner.nextLine();
		String input = scanner.nextLine();
		Stack<String> stack = new Stack<>();
		for (int alpha = 65; alpha < 65 + countOfAlpha; alpha++) {
			int value = scanner.nextInt();
			alphas.put((char) alpha, value);
		}
		for (int idx = 0; idx < input.length(); idx++) {
			if (Character.isAlphabetic(input.charAt(idx))) {
				int value = alphas.get(input.charAt(idx));
				stack.add(String.valueOf(value));
			} else {
				double b = Double.parseDouble(stack.pop());
				double a = Double.parseDouble(stack.pop());
				double result = calculate(a, b, input.charAt(idx));
				stack.add(String.valueOf(result));
			}
		}
		double answer = Double.parseDouble(stack.pop());
		System.out.println(String.format("%.2f", answer));
	}

	private static double calculate(double a, double b, char operator) {
		if (operator == '+') {
			return a + b;
		} else if (operator == '-') {
			return a - b;
		} else if (operator == '*') {
			return a * b;
		} else {
			return a / b;
		}
	}
}
