package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		int[] numbers = new int[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		Arrays.sort(numbers);
		int countOfTarget = scanner.nextInt();
		for (int idx = 0; idx < countOfTarget; idx++) {
			int target = scanner.nextInt();
			search(numbers, target);
		}
	}

	private static void search(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		boolean hasTarget = false;
		while (left <= right) {
			int mid = (left + right) / 2;
			int midValue = numbers[mid];
			if (midValue > target) {
				right = mid - 1;
			} else if (midValue < target) {
				left = mid + 1;
			} else {
				hasTarget = true;
				break;
			}
		}
		System.out.println(hasTarget ? 1 : 0);
	}

}
