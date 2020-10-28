package 스택큐;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 후위표기식 {
	static Scanner scanner = new Scanner(System.in);
	static Map<Character, Integer> priority = new HashMap<>();

	private static void init() {
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
	}

	public static void main(String[] args) {
		init();
		String input = scanner.nextLine();
		Stack<Character> stack = new Stack<>();
		for (int idx = 0; idx < input.length(); idx++) {
			if (Character.isAlphabetic(input.charAt(idx))) {
				System.out.print(input.charAt(idx));
			} else if (input.charAt(idx) == '(') {
				stack.add(input.charAt(idx));
			} else if (input.charAt(idx) == ')') {
				char c;
				do {
					c = stack.pop();
					if (c != '(') {
						System.out.print(c);
					}
				} while (c != '(');
			} else {
				while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(input.charAt(idx))) {
					System.out.print(stack.pop());
				}
				stack.add(input.charAt(idx));
			}
		}
		while (!stack.isEmpty()) {
			char c = stack.pop();
			if (c != '(' && c != ')') {
				System.out.print(c);
			}
		}
	}
}
