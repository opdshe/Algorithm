package 스택;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class 오큰수 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int countOfNumber = Integer.parseInt(bufferedReader.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] answers = new int[countOfNumber];
		Arrays.fill(answers, -1);

		for (int idx = 0; idx < countOfNumber; idx++) {
			int value = numbers[idx];
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && numbers[stack.peek()] < value) {
					Integer position = stack.pop();
					answers[position] = value;
				}
			}
			stack.push(idx);
		}
		for (int idx = 0; idx < countOfNumber; idx++) {
			bufferedWriter.write(answers[idx] + " ");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
