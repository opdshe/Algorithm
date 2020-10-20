package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 랜선자르기 {
	static Scanner scanner = new Scanner(System.in);
	static int countOfLine;
	static int target;

	public static void main(String[] args) {
		countOfLine = scanner.nextInt();
		target = scanner.nextInt();
		int[] lines = new int[countOfLine];
		for (int idx = 0; idx < countOfLine; idx++) {
			lines[idx] = scanner.nextInt();
		}
		binarySearch(lines, target);
	}

	private static void binarySearch(int[] lines, int target) {
		if (target == 1) {
			System.out.println(lines[0]);
			return;
		}
		Arrays.sort(lines);
		long left = 0;
		long right = lines[lines.length - 1];
		long answer = 0;
		while (left <= right) {
			long lineLength = (left + right) / 2;
			if (lineLength == 0) {
				lineLength = 1;
			}
			long chunk = 0;
			for (int line : lines) {
				chunk += line / lineLength;
			}
			if (chunk < target) {
				right = lineLength - 1;
			} else {
				answer = Math.max(answer, lineLength);
				left = lineLength + 1;
			}
		}
		System.out.println(answer);
	}
}
