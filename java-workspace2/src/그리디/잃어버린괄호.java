package 그리디;

import java.util.Scanner;

public class 잃어버린괄호 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input = scanner.nextLine();
		String[] split = input.split("-");
		int answer = calculate(split[0]);
		for (int i = 1; i < split.length; i++) {
			answer -= calculate(split[i]);
		}
		System.out.println(answer);
	}

	private static int calculate(String split) {
		String[] strArray = split.split("\\+");
		int sum = 0;
		for (String s : strArray) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}
