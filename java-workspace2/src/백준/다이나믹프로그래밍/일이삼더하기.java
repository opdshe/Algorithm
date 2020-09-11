package 백준.다이나믹프로그래밍;

import java.util.Scanner;

public class 일이삼더하기 {
	static Scanner scanner = new Scanner(System.in);
	static int testcase;
	static int answer;

	public static void main(String[] args) {
		testcase = scanner.nextInt();
		for (int i = 0; i < testcase; i++) {
			answer = 0;
			search(0, scanner.nextInt());
			System.out.println(answer);
		}
	}

	private static void search(int sum, int target) {
		if (sum == target) {
			answer++;
			return;
		}
		if (sum > target) {
			return;
		}
		for (int i = 1; i <= 3; i++) {
			search(sum + i, target);
		}
	}
}
