package 문자열;

import java.util.Scanner;

public class 단어뒤집기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		scanner.nextLine();
		for (int test = 0; test < testcase; test++) {
			String origin = scanner.nextLine();
			StringBuilder stringBuilder = new StringBuilder();
			for (int idx = 0; idx < origin.length(); idx++) {
				if (origin.charAt(idx) == ' ') {
					System.out.print(stringBuilder.append(" "));
					stringBuilder = new StringBuilder();
				} else {
					stringBuilder.insert(0, origin.charAt(idx));
				}
			}
			System.out.print(stringBuilder.toString());
			System.out.println();
		}
	}
}
