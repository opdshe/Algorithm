package 테스트;


import java.util.regex.Pattern;

public class TestClass {
	public static void main(String[] args) {
		Pattern pattern2 = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
		String test = "test string";
		boolean result = pattern2.matcher(test).find();

		solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
		int[][] dp = new int[triangle.length + 1][triangle.length + 1];
		for (int row = 1; row <= triangle.length; row++) {
			for (int column = 1; column <= row; column++) {
				int value = triangle[row - 1][column - 1];
				dp[row][column] = Math.max(dp[row - 1][column] + value, dp[row - 1][column - 1] + value);
			}
		}
		for (int column = 1; column <= triangle.length; column++) {
			answer = Math.max(answer, dp[triangle.length][column]);
		}
		return answer;
	}
}
