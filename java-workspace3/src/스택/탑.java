package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 탑 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		int countOfTowers = Integer.parseInt(bufferedReader.readLine());
		int[] answers = new int[countOfTowers];
		int[] towers = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		for (int idx = 0; idx < countOfTowers; idx++) {
			int height = towers[idx];
			if (stack.isEmpty()) {
				stack.push(idx);
				answers[idx] = 0;
				continue;
			}
			while (!stack.isEmpty() && towers[stack.peek()] < height) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				answers[idx] = 0;
			} else {
				answers[idx] = stack.peek() + 1;
			}
			stack.push(idx);
		}
		for (int idx = 0; idx < countOfTowers; idx++) {
			System.out.print(answers[idx] + " ");
		}
	}
}
