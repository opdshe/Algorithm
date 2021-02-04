package 스택;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String origin = scanner.nextLine();
		solution(origin);
	}

	private static void solution(String origin) {
		Stack<Character> stack = new Stack<>();
		int piece = 0;
		for (int idx = 0; idx < origin.length(); idx++) {
			char current = origin.charAt(idx);
			if (current == '(') {
				stack.push(current);
			} else {
				if (origin.charAt(idx - 1) == '(') {
					stack.pop();
					piece += stack.size();
				} else {
					piece++;
					stack.pop();
				}
			}
		}
		System.out.println(piece);
	}
}
