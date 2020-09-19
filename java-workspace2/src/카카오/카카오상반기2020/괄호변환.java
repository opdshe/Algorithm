package 카카오.카카오상반기2020;

import java.util.Stack;

public class 괄호변환 {
	public static void main(String[] args) {
		solution(")()(");
	}

	public static String solution(String p) {
		if (isCorrectString(p)) {
			System.out.println(p);
			return p;
		} else {
			String answer = getCorrectString(p);
			System.out.println(answer);
			return answer;
		}
	}

	private static String getCorrectString(String w) {
		if (w.equals("")) {
			return "";
		}
		int token = 0;
		String u = "";
		String v = "";
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i) == '(') {
				token++;
			} else {
				token--;
			}
			if (i != 0 && token == 0) {
				u = w.substring(0, i + 1);
				v = w.substring(i + 1);
				break;
			}
		}
		if (isCorrectString(u)) {
			return u + getCorrectString(v);
		} else {
			return "(" + getCorrectString(v) + ")" +
					getCutAndReverse(u);
		}
	}

	private static String getCutAndReverse(String u) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') {
				stringBuilder.append(')');
			} else {
				stringBuilder.append('(');
			}
		}
		return stringBuilder.toString();
	}

	private static boolean isCorrectString(String target) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}