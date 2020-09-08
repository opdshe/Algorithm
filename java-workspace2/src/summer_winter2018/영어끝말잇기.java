package summer_winter2018;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
	static int countOfPeople;
	static int[] countOfTurn;

	public static void main(String[] args) {
		solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
	}

	public static int[] solution(int n, String[] words) {
		countOfPeople = n;
		countOfTurn = new int[n + 1];
		return play(words);
	}

	private static int[] play(String[] words) {
		Set<String> set = new HashSet<>();
		int current = 1;
		int answerIdx = -1;
		char targetChar = words[0].charAt(0);
		for (String word : words) {
			countOfTurn[current]++;
			if (word.length() == 1) {
				answerIdx = current;
				break;
			}
			if (word.charAt(0) != targetChar) {
				answerIdx = current;
				break;
			}
			if (set.contains(word)) {
				answerIdx = current;
				break;
			}
			targetChar = word.charAt(word.length() - 1);
			set.add(word);
			if (current == countOfPeople) {
				current = 1;
			} else {
				current++;
			}
		}
		if (answerIdx == -1) {
			return new int[]{0, 0};
		} else {
			return new int[]{answerIdx, countOfTurn[answerIdx]};
		}
	}
}