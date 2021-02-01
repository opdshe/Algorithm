package 구현;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴리뉴얼 {
	static List<Character> charSets = new ArrayList<>();
	static Map<String, Integer> countMap;
	static List<String> answers = new ArrayList<>();

	public static void main(String[] args) {
		solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
	}

	public static String[] solution(String[] orders, int[] courses) {
		initCharSets(orders);
		for (int course : courses) {
			int[] orderArray = new int[course];
			countMap = new HashMap<>();
			makeCombination(orderArray, course, 0, 0);
			for (String key : countMap.keySet()) {
				for (String order : orders) {
					int c = 0;
					for (int idx = 0; idx < key.length(); idx++) {
						if (!order.contains(String.valueOf(key.charAt(idx)))) {
							break;
						} else {
							c++;
						}
					}
					if (c == key.length()) {
						Integer count = countMap.get(key);
						countMap.put(key, count + 1);
					}
				}
			}
			List<Map.Entry<String, Integer>> collect = countMap.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					.collect(Collectors.toList());
			int max = collect.get(0).getValue();
			for (Map.Entry<String, Integer> entry : collect) {
				if (entry.getValue() < 2) {
					break;
				}
				if (entry.getValue() == max) {
					answers.add(entry.getKey());
				} else {
					break;
				}
			}
		}
		answers.sort(Comparator.naturalOrder());
		return answers.toArray(new String[0]);
	}

	private static void makeCombination(int[] orderArray, int length, int level, int start) {
		if (level == length) {
			String key = Arrays.stream(orderArray).boxed()
					.map(integer -> String.valueOf(charSets.get(integer)))
					.collect(Collectors.joining());
			countMap.put(key, 0);
			return;
		}
		for (int idx = start; idx < charSets.size(); idx++) {
			orderArray[level] = idx;
			makeCombination(orderArray, length, level + 1, idx + 1);
		}
	}

	private static void initCharSets(String[] orders) {
		for (String order : orders) {
			for (int idx = 0; idx < order.length(); idx++) {
				if (!charSets.contains(order.charAt(idx))) {
					charSets.add(order.charAt(idx));
				}
			}
		}
		charSets.sort(Comparator.naturalOrder());
	}
}
