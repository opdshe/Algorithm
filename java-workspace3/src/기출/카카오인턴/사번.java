package 기출.카카오인턴;

import java.util.HashMap;
import java.util.Map;

public class 사번 {
	private static Map<int[], Boolean> roadMap = new HashMap<>();
	private static boolean[] visited;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3});
	}

	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
		init(n, roads);
		dfs(start, end, traps, 0);
		System.out.println(answer);
		return answer;
	}

	private static void dfs(int idx, int end, int[] traps, int cost) {
		if (idx == end) {
			answer = Math.min(answer, cost);
			return;
		}
		visited[idx] = true;
		boolean isTrap = isTrap(idx, traps);
		if (isTrap) {
			reverse(idx);
		}
		for (Map.Entry<int[], Boolean> entry : roadMap.entrySet()) {
			int[] key = entry.getKey();
			Boolean value = entry.getValue();
			if (key[0] == idx && value) {
				dfs(key[1], end, traps, cost + key[2]);
			}
			if ((key[1] == idx && !value)) {
				dfs(key[0], end, traps, cost + key[2]);
			}
		}
		visited[idx] = false;
		if (isTrap) {
			reverse(idx);
		}
	}

	private static void reverse(int current) {
		for (Map.Entry<int[], Boolean> entry : roadMap.entrySet()) {
			Boolean value = entry.getValue();
			entry.setValue(!value);
		}
	}

	private static boolean isTrap(int current, int[] traps) {
		for (int trap : traps) {
			if (trap == current) {
				return true;
			}
		}
		return false;
	}

	private static void init(int n, int[][] roads) {
		visited = new boolean[n + 1];
		for (int[] road : roads) {
			roadMap.put(road, true);
		}
	}
}
