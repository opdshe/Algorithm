package 백준.다이나믹프로그래밍;

import java.util.Scanner;

public class 타일링 {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int answer;

	public static void main(String[] args) {
		n = scanner.nextInt();
		System.out.println(answer);
		int maxTwo = n / 2;
		System.out.println(factorial(5));
		System.out.println(factorial(5));
		for (int i = 0; i <= maxTwo; i++) {
			int countOfOne = n - i;
			int total = (i + countOfOne - 1) / (countOfOne);
		}
	}

	private static int factorial(int target) {
		if (target == 0) {
			return 1;
		}
		if (target == 1) {
			return 1;
		}
		return target * factorial(target - 1);
	}
}
