package 다이나믹프로그래밍;

public class 가장큰정사각형찾기 {
    public static void main(String[] args) {
        solution(new int[][]{{1}});
    }

    public static int solution(int[][] board) {
        int[][] dp = deepCopy(board);
        int max = 0;
        for (int row = 1; row < board.length; row++) {
            for (int column = 1; column < board[0].length; column++) {
                if (dp[row][column] != 0) {
                    int min = Math.min(dp[row][column - 1], dp[row - 1][column - 1]);
                    min = Math.min(min, dp[row - 1][column]) + 1;
                    dp[row][column] += min;
                    max = Math.max(max, dp[row][column]);
                }
            }
        }
        System.out.println(max * max);
        return max * max;
    }

    private static int[][] deepCopy(int[][] origin) {
        if (origin == null) return null;
        int[][] result = new int[origin.length][origin[0].length];

        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
        }
        return result;
    }
}
