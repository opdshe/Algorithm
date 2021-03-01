package 깊이우선탐색;

import java.util.ArrayList;
import java.util.List;

public class GPS {
	private static List<Node> nodes = new ArrayList<>();
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		solution(7, 10, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5},
				{4, 6}, {5, 6}, {5, 7}, {6, 7}}, 6, new int[]{1, 2, 3, 3, 6, 7});
	}

	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		init(n, edge_list);
		search(k, gps_log, gps_log[0], 0, 0);
		answer = answer == Integer.MAX_VALUE ? -1 : answer;
		System.out.println(answer);
		return answer;
	}

	private static void search(int k, int[] gps_log, int current, int time, int diff) {
		if (time == k - 1) {
			if (current == gps_log[time]) {
				answer = Math.min(answer, diff);
			}
			return;
		}
		for (Integer integer : nodes.get(current).adj) {
			if (gps_log[time + 1] == integer) {
				search(k, gps_log, integer, time + 1, diff);
			} else {
				search(k, gps_log, integer, time + 1, diff + 1);
			}
		}
		if (gps_log[time + 1] == current) {
			search(k, gps_log, current, time + 1, diff);
		} else {
			search(k, gps_log, current, time + 1, diff + 1);
		}
	}

	private static void init(int n, int[][] edge_list) {
		for (int idx = 0; idx <= n; idx++) {
			nodes.add(new Node(idx));
		}
		for (int[] ints : edge_list) {
			nodes.get(ints[0]).adj.add(ints[1]);
			nodes.get(ints[1]).adj.add(ints[0]);
		}
	}

	private static class Node {
		private int idx;
		private List<Integer> adj = new ArrayList<>();

		public Node(int idx) {
			this.idx = idx;
		}
	}
}
