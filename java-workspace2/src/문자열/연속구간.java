package 문자열;

import java.util.Scanner;

public class 연속구간 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		for (int test = 0; test < 3; test++) {
			String origin = scanner.nextLine();
			char prev = origin.charAt(0);
			int count = 1;
			int answer = 1;
			for (int idx = 1; idx < origin.length(); idx++) {
				char digit = origin.charAt(idx);
				if (prev != digit) {
					answer = Math.max(answer, count);
					prev = digit;
					count = 1;
				} else {
					count++;
				}
			}
			answer = Math.max(answer, count);
			System.out.println(answer);
		}
	}
}
