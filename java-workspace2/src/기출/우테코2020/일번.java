package 기출.우테코2020;

import java.util.HashMap;

public class 일번 {
	static HashMap<String, Integer> scoreTable = new HashMap<>();

	public static void main(String[] args) {
		solution(new String[]{"A+"}, new int[]{2}, 50);
	}

	private static void initScoreTable() {
		scoreTable.put("A+", 10);
		scoreTable.put("A0", 9);
		scoreTable.put("B+", 8);
		scoreTable.put("B0", 7);
		scoreTable.put("C+", 6);
		scoreTable.put("C0", 5);
		scoreTable.put("D+", 4);
		scoreTable.put("D0", 3);
		scoreTable.put("F", 0);
	}

	public static int solution(String[] grades, int[] weights, int threshold) {
		initScoreTable();
		int sum = 0;
		for (int idx = 0; idx < weights.length; idx++) {
			sum += (weights[idx] * scoreTable.get(grades[idx]));
		}
		System.out.println(sum - threshold);
		return sum - threshold;
	}
}
