package 복습;

import java.util.Scanner;

public class 정수삼각형 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int maxFloor = scanner.nextInt();
        int answer = 0;
        int[][] costs = new int[maxFloor + 1][maxFloor + 1];
        int[][] dp = new int[maxFloor + 1][maxFloor + 1];
        for (int floor = 1; floor <= maxFloor; floor++) {
            for (int idx = 1; idx <= floor; idx++) {
                costs[floor][idx] = scanner.nextInt();
            }
        }
        for (int floor = 1; floor <= maxFloor; floor++) {
            for (int idx = 1; idx <= maxFloor; idx++) {
                dp[floor][idx] = Math.max(dp[floor - 1][idx] + costs[floor][idx],
                        dp[floor - 1][idx - 1] + costs[floor][idx]);
            }
        }
        for (int idx = 1; idx <= maxFloor; idx++) {
            answer = Math.max(answer, dp[maxFloor][idx]);
        }
        System.out.println(answer);
    }
}
