package 그래프.최단경로.다익스트라;

import java.util.*;

public class 가장먼노드 {
	static List<Integer>[] adjacent;
	static int INF = Integer.MAX_VALUE;

	public int solution(int n, int[][] edges) {
		initAdjacent(n, edges);
		return dijkstra(n, edges);
	}

	private static int dijkstra(int n, int[][] edges) {
		Map<Integer, List<Integer>> answerMap = new HashMap<>();
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
		queue.add(new Node(1, 0));
		int[] distances = new int[n + 1];
		Arrays.fill(distances, INF);
		distances[1] = 0;

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (distances[current.idx] < current.cost) {
				continue;
			}
			for (Integer adj : adjacent[current.idx]) {
				int cost = current.cost + 1;
				if (distances[adj] > cost) {
					distances[adj] = cost;
					queue.add(new Node(adj, cost));
				}
			}
		}
		for (int idx = 1; idx <= n; idx++) {
			List<Integer> list = answerMap.getOrDefault(distances[idx], new ArrayList<>());
			list.add(idx);
			answerMap.put(distances[idx], list);
		}
		Integer maxDistance = answerMap.keySet().stream()
				.max(Comparator.naturalOrder())
				.get();
		return answerMap.get(maxDistance).size();
	}

	private static void initAdjacent(int n, int[][] edges) {
		adjacent = new List[n + 1];
		for (int idx = 1; idx <= n; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			adjacent[edge[0]].add(edge[1]);
			adjacent[edge[1]].add(edge[0]);
		}
	}

	private static class Node {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
