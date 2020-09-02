package 백준.이분탐색;

import java.util.Scanner;

public class 수들의합 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		long target = scanner.nextLong();
		System.out.println(search(target));
	}

	private static long search(long target) {
		int current = 1;
		long sum = 0;
		while (true) {
			sum += current;
			if (target > sum) {
				current++;
			} else if (target == sum) {
				return current;
			} else if (target < sum) {
				break;
			}
		}
		return current - 1;
	}
}
