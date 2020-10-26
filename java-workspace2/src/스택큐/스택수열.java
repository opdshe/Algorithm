package 스택큐;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

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
		int next = 1;
		for (int idx = 0; idx < countOfNumber; idx++) {
			int target = numbers[idx];
			if (next <= target) {
				for (int num = next; num <= target; num++) {
					bufferedWriter.write("+");
					bufferedWriter.newLine();
					stack.add(num);
				}
				next = target + 1;
				bufferedWriter.write("-");
				bufferedWriter.newLine();
				stack.pop();
			} else {
				if (stack.peek() < target) {
					bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
					bufferedWriter.write("NO");
					break;
				} else if (stack.peek() == target) {
					stack.pop();
					bufferedWriter.write("-");
					bufferedWriter.newLine();
				} else {
					while (!(stack.peek() == target)) {
						stack.pop();
						bufferedWriter.write("-");
						bufferedWriter.newLine();
					}
				}
			}
		}
		bufferedWriter.flush();
	}
}
