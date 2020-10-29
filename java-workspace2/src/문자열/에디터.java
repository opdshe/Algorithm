package 문자열;

import java.io.*;
import java.util.Stack;

public class 에디터 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		String input = bufferedReader.readLine();
		for (int idx = 0; idx < input.length(); idx++) {
			left.add(input.charAt(idx));
		}
		int countOfOrder = Integer.parseInt(bufferedReader.readLine());
		for (int idx = 0; idx < countOfOrder; idx++) {
			String[] order = bufferedReader.readLine().split(" ");
			operate(left, right, order);
		}
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		while (!right.isEmpty()) {
			bufferedWriter.write(right.pop());
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
	}

	private static void operate(Stack<Character> left, Stack<Character> right, String[] order) {
		if (order[0].equals("L")) {
			if (!left.isEmpty()) {
				right.push(left.pop());
			}
		} else if (order[0].equals("D")) {
			if (!right.isEmpty()) {
				left.push(right.pop());
			}
		} else if (order[0].equals("B")) {
			if (!left.isEmpty()) {
				left.pop();
			}
		} else if (order[0].equals("P")) {
			left.push(order[1].charAt(0));
		}
	}
}
