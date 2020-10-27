package 스택큐;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class 오큰수 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int countOfNumber = Integer.parseInt(bufferedReader.readLine());
		int[] answer = new int[countOfNumber];
		int[] inputNumbers = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		Stack<Integer> stack = new Stack<>();
		for (int idx = 0; idx < countOfNumber; idx++) {
			if (stack.isEmpty()) {
				stack.add(idx);
			}
			while (!stack.isEmpty() && inputNumbers[stack.peek()] < inputNumbers[idx]) {
				answer[stack.pop()] = inputNumbers[idx];
			}
			stack.add(idx);
		}
		while (!stack.isEmpty()) {
			Integer idx = stack.pop();
			answer[idx] = -1;
		}
		for (int idx = 0; idx < countOfNumber; idx++) {
			bufferedWriter.write(answer[idx] + " ");
		}
		bufferedWriter.close();
		bufferedReader.close();
	}
}
