package 다이나믹프로그래밍;

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
        int[][] dp = new int[maxRow + 1][maxColumn + 1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        dp[1][1] = 1;
        for (int row = 1; row <= maxRow; row++) {
            for (int column = 1; column <= maxColumn; column++) {
                if (row == 1 && column == 1 || dp[row][column] != 0) {
                    continue;
                }
                if (dp[row - 1][column] > 0) {
                    dp[row][column] += (dp[row - 1][column]) % MOD;
                }
                if (dp[row][column - 1] > 0) {
                    dp[row][column] += (dp[row][column - 1]) % MOD;
                }
            }
        }
        return dp[maxRow][maxColumn] % MOD;
    }
}
