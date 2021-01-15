package 그래프.서로소집합;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 섬연결하기 {
	static List<Bridge> bridges = new ArrayList<>();

	public int solution(int n, int[][] costs) {
		int answer = 0;
		int count = 0;
		int[] parent = new int[n];
		for (int idx = 0; idx < n; idx++) {
			parent[idx] = idx;
		}
		for (int[] cost : costs) {
			bridges.add(new Bridge(cost[0], cost[1], cost[2]));
		}
		bridges.sort(Comparator.comparing(bridge -> bridge.cost));
		for (Bridge bridge : bridges) {
			if (count >= n - 1) {
				break;
			}
			int sourceParent = find(parent, bridge.source);
			int destParent = find(parent, bridge.dest);
			if (sourceParent != destParent) {
				union(parent, bridge.source, bridge.dest);
				answer += bridge.cost;
				count++;
			}
		}
		return answer;
	}

	private static void union(int[] parent, int a, int b) {
		int parentOfA = find(parent, a);
		int parentOfB = find(parent, b);
		if (parentOfA > parentOfB) {
			parent[parentOfA] = parentOfB;
		} else {
			parent[parentOfB] = parentOfA;
		}
	}

	private static int find(int[] parent, int target) {
		if (parent[target] != target) {
			return find(parent, parent[target]);
		}
		return parent[target];
	}

	private static class Bridge {
		int source;
		int dest;
		int cost;

		public Bridge(int source, int dest, int cost) {
			this.source = source;
			this.dest = dest;
			this.cost = cost;
		}
	}
}
