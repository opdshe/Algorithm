package 다이나믹프로그래밍;

import java.util.Scanner;

public class 악수 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		int[] dp = new int[countOfPeople + 1];
		solution(dp, countOfPeople);
	}

	private static void solution(int[] dp, int countOfPeople) {
		dp[1] = 1;
		if (countOfPeople >= 2) {
			dp[2] = 2;
		}
		for (int idx = 3; idx <= countOfPeople; idx++) {
			dp[idx] = (dp[idx - 1] + dp[idx - 2]) % 10;
		}
		System.out.println(dp[countOfPeople]);
	}
}
