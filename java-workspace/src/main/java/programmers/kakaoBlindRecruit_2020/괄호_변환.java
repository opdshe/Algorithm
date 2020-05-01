package programmers.kakaoBlindRecruit_2020;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class 괄호_변환 {
    public static void main(String[] args) {
        solution("()))((()");
    }

    public static String solution(String p) {
        String answer = oneCycle(p);
        System.out.println(answer);
        return answer;
    }

    public static boolean isBalanced(String s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
                continue;
            }
            close++;
        }
        return open == close;
    }

    public static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
                continue;
            }
            try {
                stack.pop();
            } catch (EmptyStackException e) {
                return false;
            }
        }
        return true;
    }

    public static String oneCycle(String w) {
        if (w.isEmpty()) {
            return w;
        }
        String u = null;
        String v = null;
        for (int i = 0; i < w.length(); i++) {
            String sub = w.substring(0, i + 1);
            if (isBalanced(sub)) {
                u = sub;
                v = w.substring(i + 1);
                break;
            }
        }
        if (isCorrect(u)) {
            return u + oneCycle(v);
        }
        StringBuilder answer =  new StringBuilder();
        answer.append("(").append(oneCycle(v)).append(")");
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                answer.append(")");
                continue;
            }
            answer.append("(");
        }
        return answer.toString();
    }
}
