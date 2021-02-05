package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 부분합 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		int target = scanner.nextInt();
		scanner.nextLine();
		int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		solution(numbers, countOfNumber, target);
	}

	private static void solution(int[] numbers, int countOfNumber, int target) {
		int left = 0;
		int minLength = Integer.MAX_VALUE;
		int right = 0;
		long sum = 0;
		while (true) {
			if (sum >= target) {
				if (right - left < minLength) {
					minLength = right - left;
				}
				sum -= numbers[left];
				left++;
			} else if (right == countOfNumber) {
				break;
			} else {
				sum += numbers[right];
				right++;
			}
		}
		System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
	}
}
