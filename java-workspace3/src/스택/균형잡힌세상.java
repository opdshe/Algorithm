package 스택;

import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌세상 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String input = scanner.nextLine();
            if (input.equals(".")) {
                break;
            }
            System.out.println(validate(input) ? "YES" : "NO");
        }
    }

    private static boolean validate(String input) {
        Stack<Character> stack = new Stack<>();
        try {
            for (int idx = 0; idx < input.length(); idx++) {
                char current = input.charAt(idx);
                if (current == '(' || current == '[') {
                    stack.push(current);
                } else if (current == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if (current == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return stack.isEmpty();
    }
}
