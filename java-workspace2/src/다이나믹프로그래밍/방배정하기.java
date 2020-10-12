package 다이나믹프로그래밍;

import java.util.Scanner;

public class 방배정하기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] rooms = new int[3];
		for (int idx = 0; idx < 3; idx++) {
			rooms[idx] = scanner.nextInt();
		}
		int target = scanner.nextInt();
		solution(rooms, target);
	}

	private static void solution(int[] rooms, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int room : rooms) {
			for (int num = room; num <= target; num++) {
				if (dp[num - room] != 0) {
					dp[num]++;
				}
			}
		}
		System.out.println(dp[target] == 0 ? 0 : 1);
	}
}
