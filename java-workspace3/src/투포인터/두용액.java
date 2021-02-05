package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 두용액 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfWater = scanner.nextInt();
		scanner.nextLine();
		int[] waters = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		Arrays.sort(waters);
		solution(waters, countOfWater);
	}

	private static void solution(int[] waters, int countOfWater) {
		int left = 0;
		int right = countOfWater - 1;
		int minGap = Integer.MAX_VALUE;
		int leftValue = Integer.MAX_VALUE;
		int rightValue = Integer.MAX_VALUE;

		while (left < right) {
			int sum = waters[left] + waters[right];
			int gap = Math.abs(sum);
			if (gap < minGap) {
				minGap = gap;
				leftValue = waters[left];
				rightValue = waters[right];
			}

			if (sum == 0) {
				break;
			} else if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(leftValue);
		System.out.println(rightValue);
	}
}
