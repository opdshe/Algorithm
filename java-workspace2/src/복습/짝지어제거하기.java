package 복습;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {

    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int idx = 0; idx < s.length(); idx++) {
            char current = s.charAt(idx);
            if (stack.isEmpty()) {
                stack.add(s.charAt(idx));
                continue;
            }
            if (stack.peek() == current) {
                stack.pop();
            } else {
                stack.add(current);
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }

}
