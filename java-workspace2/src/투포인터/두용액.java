package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 두용액 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfWater = scanner.nextInt();
		int[] waters = new int[countOfWater];
		for (int idx = 0; idx < countOfWater; idx++) {
			waters[idx] = scanner.nextInt();
		}
		Arrays.sort(waters);
		solution(waters);
	}

	private static void solution(int[] waters) {
		int left = 0;
		int right = waters.length - 1;
		long minDiff = Long.MAX_VALUE;
		int answerLeft = -1;
		int answerRight = -1;

		while (left <= right) {
			long sum = waters[left] + waters[right];
			if (sum == 0) {
				answerLeft = left;
				answerRight = right;
				break;
			}
			if (Math.abs(sum) < minDiff) {
				minDiff = Math.abs(sum);
				answerLeft = left;
				answerRight = right;
			}
			if (sum >= 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(waters[answerLeft] + " " + waters[answerRight]);
	}
}
