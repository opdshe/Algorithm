package 복습;

import java.util.HashSet;
import java.util.Set;

public class 단어변환 {
	static int answer = Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length];
		Set<String> set = new HashSet<>();
		convert(set, words, begin, target, 0);
		if (answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		return answer;
	}

	private static void convert(Set<String> set, String[] words, String current, String target, int count) {
		if (target.equals(current)) {
			answer = Math.min(answer, count);
			return;
		}
		for (String word : words) {
			if (isAvailableToConvert(current, word) && !set.contains(word)) {
				set.add(word);
				convert(set, words, word, target, count + 1);
				set.remove(word);
			}
		}
	}

	private static boolean isAvailableToConvert(String current, String target) {
		int diff = 0;
		for (int idx = 0; idx < current.length(); idx++) {
			if (current.charAt(idx) != target.charAt(idx)) {
				diff++;
			}
		}
		return diff == 1;
	}
}
