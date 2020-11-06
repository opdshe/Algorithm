package 스택큐;

import java.util.Scanner;

public class 빗물 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int maxHeight = scanner.nextInt();
		int maxColumn = scanner.nextInt();
		int[] heights = new int[maxColumn];
		int total = 0;
		for (int idx = 0; idx < maxColumn; idx++) {
			heights[idx] = scanner.nextInt();
		}
		for (int idx = 1; idx < maxColumn - 1; idx++) {
			int left = 0;
			int right = 0;
			for (int leftIdx = 0; leftIdx < idx; leftIdx++) {
				left = Math.max(left, heights[leftIdx]);
			}
			for (int rightIdx = idx + 1; rightIdx < maxColumn; rightIdx++) {
				right = Math.max(right, heights[rightIdx]);
			}
			if (heights[idx] < left && heights[idx] < right) {
				int minHeight = Math.min(left, right);
				total += minHeight - heights[idx];
			}
		}
		System.out.println(total);
	}
}
