package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 수들의합2 {
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

	private static int solution(int[] numbers, int countOfNumber, int target) {
		int left = 0;
		int right = 0;
		int sum = 0;
		int count = 0;
		while (true) {
			if (sum >= target) {
				if (sum == target) {
					//이때 right -1 까지 포함되어 있음
					//System.out.println(left +"  " + right);
					count++;
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
		System.out.println(count);
		return count;
	}
}
