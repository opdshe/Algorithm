package 기출.카카오;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
	public static void main(String[] args) {
		solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
	}

	public static int[] solution(int n, String[] words) {
		return play(n, words);
	}

	private static int[] play(int n, String[] words) {
		Set<String> set = new HashSet<>();
		char startCharacter = words[0].charAt(0);
		int player = -1;
		int turn = -1;
		for (int idx = 0; idx < words.length; idx++) {
			String word = words[idx];
			if (set.contains(word) || word.charAt(0) != startCharacter) {
				player = (idx % n) + 1;
				turn = (idx / n) + 1;
				return new int[]{player, turn};
			} else {
				set.add(word);
				startCharacter = word.charAt(word.length() - 1);
			}
		}
		return new int[]{0, 0};
	}
}