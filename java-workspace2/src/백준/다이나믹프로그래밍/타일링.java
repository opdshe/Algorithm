package 백준.다이나믹프로그래밍;

import java.util.Scanner;

public class 타일링 {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int answer;

	public static void main(String[] args) {
		n = scanner.nextInt();
		dfs(0);
		System.out.println(answer);
	}

	private static void dfs(int sum) {
		if (sum == n) {
			answer++;
		}
		if (sum > n) {
			return;
		}
		dfs(sum + 1);
		dfs(sum + 2);
	}
}
