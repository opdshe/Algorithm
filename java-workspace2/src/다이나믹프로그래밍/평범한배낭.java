package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 평범한배낭 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int countOfItem;
	static int maxWeight;
	static int[] weights;
	static int[] values;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		countOfItem = input[0];
		maxWeight = input[1];
		weights = new int[countOfItem + 1];
		values = new int[countOfItem + 1];
		dp = new int[countOfItem + 1][maxWeight + 1];

		for (int idx = 0; idx < countOfItem; idx++) {
			int[] itemInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			weights[idx] = itemInfo[0];
			values[idx] = itemInfo[1];
		}
		System.out.println(search(0, 0));
	}

	private static int search(int idx, int weightSum) {
		if (dp[idx][weightSum] != 0) {
			return dp[idx][weightSum];
		}
		if (idx == countOfItem) {
			return 0;
		}
		int include = 0;
		if (weightSum + weights[idx] <= maxWeight) {
			include = values[idx] + search(idx + 1, weightSum + weights[idx]);
		}
		int notInclude = search(idx + 1, weightSum);
		return dp[idx][weightSum] = Math.max(include, notInclude);
	}
}
