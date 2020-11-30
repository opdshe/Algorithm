package 다이나믹프로그래밍;

import java.util.Arrays;

public class 등굣길 {
    static int MOD = 1000000007;
    static int maxRow;
    static int maxColumn;

    public static void main(String[] args) {
        solution(4, 3, new int[][]{{2, 2}});
    }

    public static int solution(int m, int n, int[][] puddles) {
        maxRow = n;
        maxColumn = m;
        int[][] dp = new int[maxRow][maxColumn];
        for (int row = 0; row < maxRow; row++) {
            Arrays.fill(dp[row], -1);
        }
        int answer = dfs(puddles, dp, 0, 0) % MOD;
        return answer;
    }

    private static int dfs(int[][] puddles, int[][] dp, int row, int column) {
        if (row == maxRow - 1 && column == maxColumn - 1) {
            return 1;
        }
        if (dp[row][column] != -1) {
            return dp[row][column] % MOD;
        }
        long sum = 0;
        if (isAvailablePosition(row, column + 1)) {
            boolean isNotMatch = Arrays.stream(puddles)
                    .noneMatch((position) -> Arrays.equals(new int[]{position[0] - 1, position[1] - 1}, new int[]{row, column + 1}));
            if (isNotMatch) {
                sum += dfs(puddles, dp, row, column + 1);
            }
        }
        if (isAvailablePosition(row + 1, column)) {
            boolean isNotMatch = Arrays.stream(puddles)
                    .noneMatch((position) -> Arrays.equals(new int[]{position[0] - 1, position[1] - 1}, new int[]{row + 1, column}));
            if (isNotMatch) {
                sum += dfs(puddles, dp, row + 1, column);
            }
        }
        return dp[row][column] = (int) (sum % MOD);
    }

    private static boolean isAvailablePosition(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < maxRow &&
                nextColumn >= 0 && nextColumn < maxColumn;
    }
}
