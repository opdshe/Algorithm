package 다이나믹프로그래밍;

public class 땅따먹기 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        for (int column = 0; column < land[0].length; column++) {
            dp[0][column] = land[0][column];
        }
        for (int row = 1; row < land.length; row++) {
            for (int column = 0; column < land[0].length; column++) {
                int maxValue = 0;
                for (int compare = 0; compare < land[0].length; compare++) {
                    if (column != compare) {
                        maxValue = Math.max(maxValue, dp[row - 1][compare]);
                    }
                }
                dp[row][column] = maxValue + land[row][column];
            }
        }
        int answer = 0;
        for (int column = 0; column < land[0].length; column++) {
            answer = Math.max(answer, dp[land.length - 1][column]);
        }
        return answer;
    }
}
