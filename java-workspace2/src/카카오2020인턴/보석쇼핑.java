package 카카오2020인턴;

import java.util.*;

public class 보석쇼핑 {
	static Set<String> gemSet = new HashSet<>();
	static Map<String, Integer> gemMap = new HashMap<>();
	static int[] answer;


	public static void main(String[] args) {
		solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
	}

	public static int[] solution(String[] gems) {
		return search(gems);
	}

	private static int[] search(String[] gems) {
		Collections.addAll(gemSet, gems);
		gemSet.forEach((String gem) -> gemMap.put(gem, 0));
		answer = new int[]{0, gems.length};

		int left = 0;
		int right = 0;
		while (true) {
			if (isContainsAll()) {
				if (right - left == gemSet.size()) {
					answer = new int[]{left + 1, right};
					break;
				} else {
					gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
					if (right - left <= answer[1] - answer[0]) {
						answer = new int[]{left + 1, right};
					}
					left++;
				}
			} else if (right == gems.length) {
				break;
			} else {
				gemMap.put(gems[right], gemMap.get(gems[right]) + 1);
				right++;
			}
		}
		return answer;
	}

	private static boolean isContainsAll() {
		for (String s : gemSet) {
			if (gemMap.get(s) < 1) {
				return false;
			}
		}
		return true;
	}
}