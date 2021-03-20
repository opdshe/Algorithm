package 기출.라인2021;

import java.util.*;

public class 일번 {
	static Map<String, Map<String, Integer>> scores = new HashMap<>();
	static List<String> answers = new ArrayList<>();

	public static void main(String[] args) {
		solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
				new String[]{"PYTHON", "C++", "SQL"},
				new int[]{7, 5, 5});
	}

	public static String solution(String[] table, String[] languages, int[] preference) {
		initScores(table);
		calculate(languages, preference);
		answers.sort(Comparator.naturalOrder());
		return answers.get(0);
	}

	private static void initScores(String[] table) {
		for (String s : table) {
			String[] split = s.split(" ");
			Map<String, Integer> score = new HashMap<>();
			for (int idx = 1; idx <= 5; idx++) {
				String lan = split[idx];
				int scoreOfLan = 6 - idx;
				score.put(lan, scoreOfLan);
			}
			scores.put(split[0], score);
		}
	}

	private static void calculate(String[] languages, int[] preference) {
		int maxValue = 0;
		for (Map.Entry<String, Map<String, Integer>> entry : scores.entrySet()) {
			String group = entry.getKey();
			Map<String, Integer> scores = entry.getValue();
			int sum = 0;
			for (int idx = 0; idx < languages.length; idx++) {
				int score = scores.getOrDefault(languages[idx], 0);
				sum += score * preference[idx];
			}
			if (sum > maxValue) {
				maxValue = sum;
				answers = new ArrayList<>();
				answers.add(group);
			} else if (sum == maxValue) {
				answers.add(group);
			}
		}
	}
}
