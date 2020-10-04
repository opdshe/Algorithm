package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfCup = Integer.parseInt(bufferedReader.readLine());
		int[] quantities = new int[countOfCup];
		for (int idx = 0; idx < countOfCup; idx++) {
			quantities[idx] = Integer.parseInt(bufferedReader.readLine());
		}
		solution(quantities, countOfCup);
	}

	private static void solution(int[] quantities, int countOfCup) {
		int[] dp = new int[countOfCup];
		dp[0] = quantities[0];
		if (countOfCup >= 2) {
			dp[1] = quantities[0] + quantities[1];
		}
		if (countOfCup >= 3) {
			dp[2] = Math.max(dp[1], Math.max(quantities[0] + quantities[2], quantities[1] + quantities[2]));
		}
		for (int idx = 3; idx < countOfCup; idx++) {
			int currentQuantity = quantities[idx];
			dp[idx] = Math.max(dp[idx - 3] + quantities[idx - 1] + currentQuantity,
					dp[idx - 2] + currentQuantity);
			dp[idx] = Math.max(dp[idx], dp[idx - 1]);
		}
		System.out.println(dp[countOfCup - 1]);
	}
}