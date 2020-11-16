package 복습;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfString = scanner.nextInt();
		scanner.nextLine();
		for (int input = 0; input < countOfString; input++) {
			String parenthesis = scanner.nextLine();
			System.out.println(isValid(parenthesis) ? "YES" : "NO");
		}
	}

	private static boolean isValid(String parenthesis) {
		Stack<Character> stack = new Stack<>();
		boolean isValid = true;
		for (int idx = 0; idx < parenthesis.length(); idx++) {
			char c = parenthesis.charAt(idx);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					isValid = false;
					break;
				} else {
					stack.pop();
				}
			}
		}
		if (stack.size() > 0) {
			isValid = false;
		}
		return isValid;
	}
}
