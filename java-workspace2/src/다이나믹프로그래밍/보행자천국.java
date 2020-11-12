package 다이나믹프로그래밍;


public class 보행자천국 {
	static int maxRow;
	static int maxColumn;

	public static void main(String[] args) {
		solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}});
	}

	public static int solution(int m, int n, int[][] cityMap) {
		int MOD = 20170805;
		maxRow = m;
		maxColumn = n;
		int[][][] dp = new int[2][m][n];
		int result = dfs(cityMap, dp, 0, 0, 0) % MOD;
		System.out.println(result);
		return result;
	}

	//direction 0 : 가로, 1: 세로
	private static int dfs(int[][] cityMap, int[][][] dp, int direction, int row, int column) {
		if (row == maxRow - 1 && column == maxColumn - 1) {
			return 1;
		}
		if (dp[direction][row][column] != 0) {
			return dp[direction][row][column];
		}
		int total = 0;
		if (cityMap[row][column] == 0) {
			if (row + 1 < maxRow) {
				total += dfs(cityMap, dp, 1, row + 1, column);
			}
			if (column + 1 < maxColumn) {
				total += dfs(cityMap, dp, 0, row, column + 1);
			}
		} else if (cityMap[row][column] == 1) {
			return dp[direction][row][column];
		} else if (cityMap[row][column] == 2) {
			if (direction == 0) {
				if (column + 1 < maxColumn) {
					total += dfs(cityMap, dp, 0, row, column + 1);
				}
			} else {
				if (row + 1 < maxRow) {
					total += dfs(cityMap, dp, 1, row + 1, column);
				}
			}
		}
		return dp[direction][row][column] = total;
	}
}
