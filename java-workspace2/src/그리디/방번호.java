package 그리디;

import java.util.*;

public class 방번호 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		int[] costs = new int[countOfNumber];
		for (int number = 0; number < countOfNumber; number++) {
			costs[number] = scanner.nextInt();
		}
		int assets = scanner.nextInt();
		String answer = solution(costs, countOfNumber, assets);
		System.out.println(answer);
	}

	private static String solution(int[] costs, int countOfNumber, int assets) {
		String[] dp = new String[assets + 1];
		Arrays.fill(dp, "");
		for (int number = countOfNumber - 1; number >= 0; number--) {
			int cost = costs[number];
			for (int c = cost; c <= assets; c++) {
				String currentTargetValue = dp[c - cost];
				String candidateValue = currentTargetValue + String.valueOf(number);
				if (candidateValue.length() >= 2 && candidateValue.charAt(0) == '0') {
					candidateValue = "0";
				}
				if (dp[c].length() < candidateValue.length()) {
					dp[c] = candidateValue;
				} else if (dp[c].length() == candidateValue.length()) {
					List<String> list = new ArrayList<>();
					list.add(dp[c]);
					list.add(candidateValue);
					list.sort(Comparator.reverseOrder());
					dp[c] = list.get(0);
				}
			}
		}
		return dp[assets];
	}
}
