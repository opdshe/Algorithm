package 기출.쿠팡;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 삼번 {
	static Map<Integer, Diff> diffMap = new HashMap<>();

	public static void main(String[] args) {
		solution(2, new int[]{2, 4, 5, 6, 8});
	}

	private static int solution(int k, int[] scores) {
		for (int idx = 1; idx < scores.length; idx++) {
			int diff = scores[idx - 1] - scores[idx];
			Diff currentDiff;
			if (diffMap.containsKey(diff)) {
				currentDiff = diffMap.get(diff);
			} else {
				currentDiff = new Diff();
			}
			currentDiff.count++;
			currentDiff.candidates.add(idx - 1);
			currentDiff.candidates.add(idx);
			diffMap.put(diff, currentDiff);
		}

		for (Map.Entry<Integer, Diff> entry : diffMap.entrySet()) {
			if (entry.getValue().count >= k) {
				for (Integer candidate : entry.getValue().candidates) {
					scores[candidate] = -1;
				}
			}
		}

		int count = 0;
		for (int score : scores) {
			System.out.println(score);
			if (score != -1) {
				count++;
			}
		}

		System.out.println(count);
		return count;
	}

	private static class Diff {
		private int count;
		private List<Integer> candidates = new ArrayList<>();
	}
}
