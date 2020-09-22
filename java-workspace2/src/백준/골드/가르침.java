package 백준.골드;

import java.util.*;

public class 가르침 {
	static Map<String, Integer> map = new HashMap<>();
	static Scanner scanner = new Scanner(System.in);
	static Set<Character> defaultSet = new HashSet<>(Arrays.asList('a', 'n', 't', 'i', 'c'));
	static int N;
	static int K;

	public static void main(String[] args) {
		N = scanner.nextInt();
		K = scanner.nextInt();
		scanner.nextLine();
		if (K < 5) {
			System.out.println(0);
			return;
		}
		for (int idx = 0; idx < N; idx++) {
			String original = scanner.nextLine();
			String target = original.substring(4, original.length() - 4);
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < target.length(); i++) {
				if (!defaultSet.contains(target.charAt(i))) {
					set.add(target.charAt(i));
				}
			}
			if (set.size() > K - 5) {
				continue;
			}
			List<Character> list = new ArrayList<>(set);
			list.sort(Comparator.naturalOrder());
			StringBuilder stringBuilder = new StringBuilder();
			list.forEach(stringBuilder::append);
			Integer current = map.getOrDefault(stringBuilder.toString(), 0);
			current++;
			map.put(stringBuilder.toString(), current);
		}
		int max = 0;
		for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
			System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue());
			max = Math.max(max, stringIntegerEntry.getValue());
		}
		System.out.println(max);
	}
}
