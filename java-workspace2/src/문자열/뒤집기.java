package 문자열;

import java.util.Scanner;

public class 뒤집기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input = scanner.nextLine();
		int[] counts = new int[2];
		char prev = input.charAt(0);
		int count = 1;
		for (int idx = 1; idx < input.length(); idx++) {
			char current = input.charAt(idx);
			if (current == prev) {
				count++;
			} else {
				counts[Integer.parseInt(String.valueOf(prev))]++;
				prev = current;
				count = 1;
			}
		}
		counts[Integer.parseInt(String.valueOf(prev))]++;
		int answer = Math.min(counts[0], counts[1]);
		System.out.println(answer);
	}
}