package 백준.다이나믹프로그래밍;

import java.util.Scanner;

public class 일이삼더하기 {
	static int[] array;
	static int countOfCase;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		countOfCase = scanner.nextInt();
		for (int i = 0; i < countOfCase; i++) {
			int target = scanner.nextInt();
			dynamicProgramming(target);
		}
	}

	private static void dynamicProgramming(int target) {
		dfs(0, target);
		System.out.println(answer);
		answer = 0;
	}

	private static void dfs(int sum, int target) {
		if (sum == target) {
			answer++;
		}
		if (sum > target) {
			return;
		}
		for (int i = 1; i <= 3; i++) {
			dfs(sum + i, target);
		}
	}
}
