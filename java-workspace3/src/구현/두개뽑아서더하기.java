package 구현;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 두개뽑아서더하기 {
	public static int[] orders = new int[2];
	public static Set<Integer> answerSet = new HashSet<>();

	public int[] solution(int[] numbers) {
		combine(numbers, 0, 0);
		return answerSet.stream()
				.sorted(Comparator.naturalOrder())
				.mapToInt(Integer::valueOf)
				.toArray();
	}

	private static void combine(int[] numbers, int level, int start) {
		if (level == 2) {
			int a = numbers[orders[0]];
			int b = numbers[orders[1]];
			answerSet.add(a + b);
			return;
		}
		for (int idx = start; idx < numbers.length; idx++) {
			orders[level] = idx;
			combine(numbers, level + 1, idx + 1);
		}
	}
}
