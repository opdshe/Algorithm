package 복습;

public class 정수삼각형 {
	public static void main(String[] args) {
		solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
	}

	public static int solution(int[][] triangle) {
		int[][] dp = new int[triangle.length][triangle.length];
		dp[0][0] = triangle[0][0];
		for (int floor = 1; floor < triangle.length; floor++) {
			for (int column = 0; column <= floor; column++) {
				int cost = triangle[floor][column];
				if (column - 1 >= 0) {
					dp[floor][column] = Math.max(dp[floor][column], dp[floor - 1][column - 1] + cost);
				}
				dp[floor][column] = Math.max(dp[floor][column], dp[floor - 1][column] + cost);
			}
		}
		int answer = 0;
		for (int column = 0; column < triangle.length; column++) {
			answer = Math.max(answer, dp[triangle.length - 1][column]);
		}
		System.out.println(answer);
		return answer;
	}
}
