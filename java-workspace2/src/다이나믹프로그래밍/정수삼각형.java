package 다이나믹프로그래밍;

import java.util.Scanner;

public class 정수삼각형 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfFloor = scanner.nextInt();
		int[][] numbers = new int[countOfFloor + 1][countOfFloor + 1];
		for (int floor = 1; floor <= countOfFloor; floor++) {
			for (int column = 1; column <= floor; column++) {
				numbers[floor][column] = scanner.nextInt();
			}
		}
		solution(numbers, countOfFloor);
	}

	private static void solution(int[][] numbers, int countOfFloor) {
		int[][] dp = new int[countOfFloor + 1][countOfFloor + 1];
		dp[1][1] = numbers[1][1];
		for (int floor = 2; floor <= countOfFloor; floor++) {
			for (int column = 1; column <= floor; column++) {
				dp[floor][column] = Math.max(dp[floor - 1][column] + numbers[floor][column],
						dp[floor - 1][column - 1] + numbers[floor][column]);
			}
		}
		int answer = 0;
		for (int column = 1; column <= countOfFloor; column++) {
			answer = Math.max(answer, dp[countOfFloor][column]);
		}
		System.out.println(answer);
	}
}
