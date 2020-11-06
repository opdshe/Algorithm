package 문자열;

import java.util.Scanner;

public class 펠린드롬확인 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input = scanner.nextLine();
		String reversedInput = new StringBuilder(input).reverse().toString();
		System.out.println(input.equals(reversedInput) ? 1 : 0);
	}
}
