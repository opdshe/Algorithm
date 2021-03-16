package 문자열;

import java.util.Scanner;

public class 잃어버린괄호 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String origin = scanner.nextLine();
		String[] split = origin.split("-");
		int answer = calculate(split[0]);
		for (int idx = 1; idx < split.length; idx++) {
			answer -= calculate(split[idx]);
		}
		System.out.println(answer);
	}

	private static int calculate(String origin) {
		int sum = 0;
		String[] split = origin.split("\\+");
		for (String s : split) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}
