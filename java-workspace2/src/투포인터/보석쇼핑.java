package 투포인터;

import java.util.*;

public class 보석쇼핑 {
	static Set<String> gemSet = new HashSet<>();
	static Map<String, Integer> gemMap = new HashMap<>();

	public static void main(String[] args) {
		solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
	}

	public static int[] solution(String[] gems) {
		gemSet.addAll(Arrays.asList(gems));
		int[] answer = search(gems);
		return answer;
	}

	private static int[] search(String[] gems) {
		int left = 0;
		int right = 0;
		int[] answer = new int[]{0, gems.length};


		while (true) {
			if (gemMap.size() == gemSet.size()) {
				if (right - left < answer[1] - answer[0]) {
					answer = new int[]{left, right};
				}
				if (gemMap.get(gems[left]) == 1) {
					gemMap.remove(gems[left]);
				} else {
					Integer current = gemMap.getOrDefault(gems[left], 0);
					gemMap.put(gems[left], current - 1);
				}
				left++;
			} else if (right == gems.length) {
				break;
			} else {
				int current = gemMap.getOrDefault(gems[right], 0);
				gemMap.put(gems[right], current + 1);
				right++;
			}
		}
		answer = new int[]{answer[0] + 1, answer[1]};
		return answer;
	}
}
