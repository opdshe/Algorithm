package 스택큐;

import java.util.Stack;

public class 짝지어제거하기 {
	public static void main(String[] args) {
		solution("aaa");
	}

	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (int idx = 0; idx < s.length(); idx++) {
			if (stack.empty()) {
				stack.add(s.charAt(idx));
			} else {
				if (stack.peek() == s.charAt(idx)) {
					stack.pop();
				} else {
					stack.add(s.charAt(idx));
				}
			}
		}
		return stack.size() == 0 ? 0 : 1;
	}

}
