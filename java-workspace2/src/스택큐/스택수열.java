package 스택큐;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int countOfNumber = scanner.nextInt();
		int[] numbers = new int[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		solution(numbers, countOfNumber);
	}

	private static void solution(int[] numbers, int countOfNumber) throws IOException {
		Stack<Integer> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();
		int next = 1;
		for (int idx = 0; idx < countOfNumber; idx++) {
			int target = numbers[idx];
			if (next <= target) {
				for (int num = next; num <= target; num++) {
					stringBuilder.append("+").append("\n");
					stack.add(num);
				}
				next = target + 1;
				stringBuilder.append("-").append("\n");
				stack.pop();
			} else {
				if (stack.peek() < target) {
					stringBuilder = new StringBuilder();
					stringBuilder.append("NO");
					break;
				} else if (stack.peek() == target) {
					stack.pop();
					stringBuilder.append("-").append("\n");
				} else {
					while (!(stack.peek() == target)) {
						stack.pop();
						stringBuilder.append("-").append("\n");
					}
				}
			}
		}
		System.out.println(stringBuilder.toString());
	}
}
