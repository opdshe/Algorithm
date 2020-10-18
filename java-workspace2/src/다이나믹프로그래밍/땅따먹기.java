package 다이나믹프로그래밍;

public class 땅따먹기 {
	public static void main(String[] args) {
		solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
	}

	private static int solution(int[][] land) {
		int[][] dp = new int[land.length][land[0].length];
		int answer = 0;
		for (int column = 0; column < land[0].length; column++) {
			dp[0][column] = land[0][column];
		}
		for (int row = 1; row < land.length; row++) {
			for (int column = 0; column < land[0].length; column++) {
				for (int prev = 0; prev < land[0].length; prev++) {
					if (column != prev) {
						dp[row][column] = Math.max(dp[row][column], dp[row - 1][prev] + land[row][column]);
						answer = Math.max(answer, dp[row][column]);
					}
				}
			}
		}
		System.out.println(answer);
		return answer;
	}
}
