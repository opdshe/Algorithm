package 기출.NHN;

import java.util.Scanner;
import java.util.Stack;

public class 삼번 {
	private static void solution(int numOfOrder, String[] orderArr) {
		for (String s : orderArr) {
			convert(s);
		}
	}

	private static void convert(String origin) {
		int length = origin.length();
		Stack<Character> stack = new Stack<>();
		StringBuilder str = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		for (int idx = 0; idx < length; idx++) {
			char c = origin.charAt(idx);
			stack.add(c);
		}
		while (stack.size() > 0) {
			Character c = stack.pop();
			if (Character.isAlphabetic(c)) {
				str.insert(0, c);
			} else if (c == '(') {
				//앞에 숫자
				char prev = stack.pop();
				if (Character.isAlphabetic(prev)) {
					StringBuilder newString = new StringBuilder();
					for (int idx = 0; idx < str.length(); idx++) {
						newString.append(prev);
						newString.append(str.charAt(idx));
					}
					str = newString;
				} else if (Character.isDigit(prev)) {
					int count = Integer.parseInt(String.valueOf(prev));
					String copy = str.toString();
					for (int r = 1; r <= count - 1; r++) {
						str.insert(0, copy);
					}
				}
			} else if (c == ')') {
				answer.insert(0, str);
				str = new StringBuilder();
			} else if (Character.isDigit(c)) {
				int count = Integer.parseInt(String.valueOf(c));
				String copy = str.toString();
				for (int r = 1; r <= count - 1; r++) {
					str.insert(0, copy);
				}
			}
		}
		answer.insert(0, str);
		System.out.println(answer);
	}

	private static class InputData {
		int numOfOrder;
		String[] orderArr;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.orderArr = new String[inputData.numOfOrder];
			for (int i = 0; i < inputData.numOfOrder; i++) {
				inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfOrder, inputData.orderArr);
	}
}
