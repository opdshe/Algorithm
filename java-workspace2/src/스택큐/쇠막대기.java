package 스택큐;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input = scanner.nextLine();
		input = input.replace("()", "1");
		Stack<Character> stack = new Stack<>();
		int split = 0;
		for (int idx = 0; idx < input.length(); idx++) {
			char c = input.charAt(idx);
			if (c == '(') {
				stack.add('(');
			} else if (c == '1') {
				split += stack.size();
			} else {
				split++;
				stack.pop();
			}
		}
		System.out.println(split);
	}
}
