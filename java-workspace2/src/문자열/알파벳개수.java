package 문자열;

import java.util.Scanner;

public class 알파벳개수 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] counts = new int[26];
		String input = scanner.nextLine();
		for (int idx = 0; idx < input.length(); idx++) {
			char alpha = input.charAt(idx);
			counts[(int) alpha - 97]++;
		}
		for (int idx = 0; idx < 26; idx++) {
			System.out.print(counts[idx] + " ");
		}
	}
}
