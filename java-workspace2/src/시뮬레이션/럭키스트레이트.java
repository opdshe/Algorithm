package 시뮬레이션;

import java.util.Scanner;

public class 럭키스트레이트 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input = scanner.nextLine();
		if (isReady(input)) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}

	}

	private static boolean isReady(String input) {
		int middle = input.length() / 2;
		int left = 0;
		int right = 0;
		for (int idx = 0; idx < middle; idx++) {
			left += Integer.parseInt(String.valueOf(input.charAt(idx)));
		}
		for (int idx = middle; idx < input.length(); idx++) {
			right += Integer.parseInt(String.valueOf(input.charAt(idx)));
		}
		return left == right;
	}
}
