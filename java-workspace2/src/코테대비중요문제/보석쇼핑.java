package 코테대비중요문제;

import java.util.*;

public class 보석쇼핑 {
	static Set<String> gemSet = new HashSet<>();
	static Map<String, Integer> gemMap = new HashMap<>();

	public static void main(String[] args) {
		solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE"});
	}

	public static int[] solution(String[] gems) {
		Collections.addAll(gemSet, gems);
		return search(gems);
	}

	private static int[] search(String[] gems) {
		int right = 0;
		int left = 0;
		int[] answer = new int[]{0, gems.length};

		while (true) {
			if (gemMap.size() == gemSet.size()) {
				if (answer[1] - answer[0] > right - left) {
					answer = new int[]{left, right};
				}
				Integer currentCount = gemMap.get(gems[left]);
				if (currentCount == 1) {
					gemMap.remove(gems[left]);
				} else {
					gemMap.put(gems[left], currentCount - 1);
				}
				left++;
			} else if (right == gems.length) {
				break;
			} else {
				Integer current = gemMap.getOrDefault(gems[right], 0);
				gemMap.put(gems[right], current + 1);
				right++;
			}
		}
		answer = new int[]{answer[0] + 1, answer[1]};
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}