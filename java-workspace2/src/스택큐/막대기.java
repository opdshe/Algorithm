package 스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 막대기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfPoll = Integer.parseInt(bufferedReader.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int idx = 0; idx < countOfPoll; idx++) {
			int value = Integer.parseInt(bufferedReader.readLine());
			while (!stack.isEmpty() && stack.peek() <= value) {
				stack.pop();
			}
			stack.add(value);
		}
		System.out.println(stack.size());
	}
}
