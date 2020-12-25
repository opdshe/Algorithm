package 스택;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = scanner.nextInt();
        scanner.nextLine();
        for (int test = 0; test < testcase; test++) {
            String input = scanner.nextLine();
            validate(input);
        }
    }

    private static void validate(String input) {
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        for (int idx = 0; idx < input.length(); idx++) {
            char current = input.charAt(idx);
            if (current == '(') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            isValid = false;
        }
        System.out.println(isValid ? "YES" : "NO");
    }
}
