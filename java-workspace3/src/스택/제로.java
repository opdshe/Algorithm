package 스택;

import java.util.Scanner;
import java.util.Stack;

public class 제로 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int countOfNumber = scanner.nextInt();
		int answer = 0;
		for (int i = 0; i < countOfNumber; i++) {
			int number = scanner.nextInt();
			if (number == 0) {
				stack.pop();
			} else {
				stack.push(number);
			}
		}
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}
}
