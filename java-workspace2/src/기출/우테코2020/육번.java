package 기출.우테코2020;

import java.util.*;

public class 육번 {
	static HashMap<String, int[]> scores = new HashMap<>();

	public static void main(String[] args) {
		solution(new String[]{
				"001 1 100",
				"002 1 100"});
	}

	public static String[] solution(String[] logs) {
		Set<String> studentIdSet = new HashSet<>();
		for (String log : logs) {
			String[] splitLog = log.split(" ");
			studentIdSet.add(splitLog[0]);
			if (!scores.containsKey(splitLog[0])) {
				scores.put(splitLog[0], new int[101]);
			}
			int[] score = scores.get(splitLog[0]);
			score[Integer.parseInt(splitLog[1])] = Integer.parseInt(splitLog[2]);
			scores.put(splitLog[0], score);
		}
		List<String> studentIds = new ArrayList<>(studentIdSet);
		Set<String> cheaters = new HashSet<>();
		for (int pivot = 0; pivot < studentIds.size() - 1; pivot++) {
			for (int compare = pivot + 1; compare < studentIds.size(); compare++) {
				int[] pivotScore = scores.get(studentIds.get(pivot));
				int[] compareScore = scores.get(studentIds.get(compare));
				int countOfSolvedProblem = 0;
				boolean isCheater = true;
				for (int problem = 1; problem <= 100; problem++) {
					if (pivotScore[problem] > 0) {
						countOfSolvedProblem++;
					}
					if (pivotScore[problem] != compareScore[problem]) {
						isCheater = false;
						break;
					}
				}
				if (isCheater) {
					if (countOfSolvedProblem >= 5) {
						cheaters.add(studentIds.get(pivot));
						cheaters.add(studentIds.get(compare));
					}
				}
			}
		}
		List<String> result = new ArrayList<>(cheaters);
		result.sort(Comparator.naturalOrder());
		String[] answer;
		if (result.size() > 0) {
			answer = result.stream()
					.toArray(size -> new String[result.size()]);
		} else {
			answer = new String[]{"None"};
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
