package 기출.네이버2020하반기;

import java.util.Arrays;

public class 삼번 {
	static boolean[] visited;
	static int[] array;
	static int count = 0;

	public static void main(String[] args) {
		solution(5);

	}

	public static long solution(int k) {
		int[] cost = new int[]{0, 1, 1, 1, 3, 3, 1};
		int[] dp = new int[k + 1];
		dp[1] = 0;
		for (int idx = 1; idx <= k; idx++) {
			count = 0;
			combine(dp, idx, 0);
			dp[idx] = cost[idx] + count;
		}
		System.out.println(Arrays.toString(dp));
		return 0;
	}

	private static void combine(int[] dp, int maxIdx, int sum) {
		visited = new boolean[maxIdx];
		array = new int[maxIdx];
		dfs(dp, maxIdx, 0, 0, 0);
	}

	private static void dfs(int[] dp, int maxIdx, int count, int sum, int level) {
		if (count >= maxIdx) {
			System.out.println("current maxIdx " + maxIdx);
			int total = 0;
			for (int idx = 0; idx < level; idx++) {
				if (array[idx] != -1) {
					total += array[idx];
				}
			}
			if (total == maxIdx) {
				System.out.println(Arrays.toString(array));
				count++;
			}
			System.out.println("count" + count);
			return;
		}
		for (int idx = 1; idx < maxIdx; idx++) {
			array[level] = -1;
			dfs(dp, maxIdx, count + 1, sum, level + 1);
			array[level] = idx;
			dfs(dp, maxIdx, count + 1, sum + dp[idx], level + 1);
		}
	}
}
