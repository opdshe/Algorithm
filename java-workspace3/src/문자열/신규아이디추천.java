package 문자열;

import java.util.Stack;

public class 신규아이디추천 {

	public static String solution(String new_id) {
		StringBuilder answer = new StringBuilder(new_id.toLowerCase());
		answer = new StringBuilder(answer.toString().replaceAll("[^a-z0-9._-]", ""));
		answer = new StringBuilder(removeContinuousDot(answer.toString()));
		answer = new StringBuilder(removeEndDot(answer.toString()));
		if (answer.length() == 0) {
			answer = new StringBuilder("a");
		}
		if (answer.length() >= 16) {
			answer = new StringBuilder(answer.substring(0, 15));
			if (answer.charAt(answer.length() - 1) == '.') {
				answer = new StringBuilder(answer.substring(0, 14));
			}
		}
		if (answer.length() <= 2) {
			char lastChar = answer.charAt(answer.length() - 1);
			while (answer.length() < 3) {
				answer.append(lastChar);
			}
		}
		System.out.println(answer.toString());
		return answer.toString();
	}

	private static String removeEndDot(String origin) {
		if (origin.charAt(0) == '.') {
			origin = origin.substring(1);
		}
		if (origin.length() > 0 && origin.charAt(origin.length() - 1) == '.') {
			origin = origin.substring(0, origin.length() - 1);
		}
		return origin;
	}

	private static String removeContinuousDot(String origin) {
		Stack<Character> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();
		for (int idx = 0; idx < origin.length(); idx++) {
			char current = origin.charAt(idx);
			if (current == '.') {
				if (!stack.isEmpty() && stack.peek() == '.') {
					stack.pop();
				}
			}
			stack.push(current);
		}
		while (!stack.isEmpty()) {
			stringBuilder.insert(0, stack.pop());
		}
		return stringBuilder.toString();
	}
}
