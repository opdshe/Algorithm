package 기출.카카오커머스;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 이번 {
	private static boolean[] visited;
	private static int[] orders;
	private static int answer = 0;

	public static int solution(int[][] needs, int r) {
		int answer = 0;
		int[] numbers = IntStream.range(0, needs[0].length).toArray();
		combine(needs, numbers, r);
		return answer;
	}

	private static void combine(int[][] needs, int[] numbers, int n) {
		visited = new boolean[numbers.length];
		orders = new int[n];
		dfs(needs, numbers, 0, 0);
	}

	private static void dfs(int[][] needs, int[] numbers, int start, int level) {
		if (level == orders.length) {
			List<Integer> has = Arrays.stream(orders).boxed()
					.collect(Collectors.toList());
			int count = 0;
			for (int[] need : needs) {
				boolean canMake = true;
				for (int idx = 0; idx < need.length; idx++) {
					if (need[idx] == 1 && !has.contains(idx)) {
						canMake = false;
						break;
					}
				}
				if (canMake) {
					count++;
				}
			}
			answer = Math.max(count, answer);
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				orders[level] = i;
				dfs(needs, numbers, i + 1, level + 1);
				visited[i] = false;
			}
		}
	}
}
