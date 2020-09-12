package 카카오2020하반기;

import java.util.*;

public class 이번 {
	static Map<String, Integer> dishes = new HashMap<>();
	static List<String> answer = new ArrayList<>();
	static boolean[] visited;
	static int[] array;
	static List[] answerList;

	public static void main(String[] args) {
		solution(new String[]{"XYZ", "XWY", "WXA"},
				new int[]{2, 3, 4});
	}

	public static String[] solution(String[] orders, int[] course) {
		for (String order : orders) {
			for (int countOfDish : course) {
				combine(order, countOfDish);
			}
		}
		answerList = new List[course.length];
		for (int i = 0; i < course.length; i++) {
			int len = course[i];
			int maxCount = 0;
			answerList[i] = new ArrayList();
			for (Map.Entry<String, Integer> stringIntegerEntry : dishes.entrySet()) {
				String key = stringIntegerEntry.getKey();
				Integer count = stringIntegerEntry.getValue();
				if (key.length() == len) {
					if (count > maxCount && count >= 2) {
						if (answerList[i].size() > 0) {
							answerList[i].clear();
						}
						answerList[i].add(key);
						maxCount = count;
					} else if (count == maxCount && count >= 2) {
						answerList[i].add(key);
					}
				}
			}
		}
		for (int i = 0; i < course.length; i++) {
			answer.addAll(answerList[i]);
		}
		answer.sort(Comparator.naturalOrder());
		return answer.stream().toArray(size -> new String[answer.size()]);
	}

	private static void combine(String dish, int n) {
		visited = new boolean[dish.length()];
		array = new int[n];
		dfs(dish, 0, 0);
	}

	private static void dfs(String dish, int start, int level) {
		if (level == array.length) {
			List<Character> dishList = new ArrayList<>();
			StringBuilder stringBuilder = new StringBuilder();
			for (int value : array) {
				dishList.add(dish.charAt(value));
			}
			dishList.sort(Comparator.naturalOrder());
			dishList.forEach(stringBuilder::append);

			if (dishes.containsKey(stringBuilder.toString())) {
				dishes.put(stringBuilder.toString(), dishes.get(stringBuilder.toString()) + 1);
			} else {
				dishes.put(stringBuilder.toString(), 1);
			}
			return;
		}

		for (int i = start; i < dish.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[level] = i;
				dfs(dish, i + 1, level + 1);
				visited[i] = false;
			}
		}
	}
}