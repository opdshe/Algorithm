package 스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 탑 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfNumber = Integer.parseInt(bufferedReader.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] answer = new int[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			if (stack.isEmpty()) {
				stack.add(idx);
				continue;
			}
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[idx]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				stack.add(idx);
			} else {
				answer[idx] = stack.peek() + 1;
			}
			stack.push(idx);
		}

		for (int idx = 0; idx < countOfNumber; idx++) {
			System.out.print(answer[idx] + " ");
		}
	}
}
