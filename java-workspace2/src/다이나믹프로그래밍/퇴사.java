package 다이나믹프로그래밍;

import java.util.Scanner;

public class 퇴사 {
	static Scanner scanner = new Scanner(System.in);
	static int[] requiredTime;
	static int[] profits;

	public static void main(String[] args) {
		int countOfConsult = scanner.nextInt();
		requiredTime = new int[countOfConsult + 1];
		profits = new int[countOfConsult + 1];
		for (int idx = 1; idx <= countOfConsult; idx++) {
			requiredTime[idx] = scanner.nextInt();
			profits[idx] = scanner.nextInt();
		}
		int[][] dp = new int[countOfConsult + 1][countOfConsult + 1];
		System.out.println(go(dp, 1, countOfConsult));

	}


	private static int go(int[][] dp, int day, int countOfConsult) {
		if (day > countOfConsult) {
			return 0;
		}
		if (dp[day][day] != 0) {
			return dp[day][day];
		}
		int include = 0;
		int notInclude;
		if (day + requiredTime[day] <= countOfConsult + 1) {
			include = profits[day] + go(dp, day + requiredTime[day], countOfConsult);
		}
		notInclude = go(dp, day + 1, countOfConsult);
		return dp[day][day] = Math.max(include, notInclude);
	}
}
