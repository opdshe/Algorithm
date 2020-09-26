package 네이버2020하반기;

import java.util.*;

public class 이번 {
	static Map<Integer, List<Edge>> tree = new HashMap<>();

	public static void main(String[] args) {
		solution(9, new int[][]{{0, 2}, {2, 1}, {2, 4}, {3, 5}, {5, 4}, {5, 7}, {7, 6}, {6, 8}});
	}

	public static int[] solution(int n, int[][] edges) {
		List<Integer> answer = new ArrayList<>();
		int[] inDegree = new int[n];
		boolean[] visited = new boolean[n];
		for (int nodeIdx = 0; nodeIdx < n; nodeIdx++) {
			tree.put(nodeIdx, new ArrayList<>());
		}
		for (int edgeIdx = 0; edgeIdx < edges.length; edgeIdx++) {
			int source = edges[edgeIdx][0];
			int dest = edges[edgeIdx][1];
			inDegree[source]++;
			inDegree[dest]++;
			List<Edge> sourceEdges = tree.get(source);
			sourceEdges.add(new Edge(edgeIdx, dest));
			List<Edge> destEdges = tree.get(dest);
			destEdges.add(new Edge(edgeIdx, source));
			tree.put(source, sourceEdges);
			tree.put(dest, destEdges);
		}
		for (int nodeIdx = 0; nodeIdx < n; nodeIdx++) {
			if (inDegree[nodeIdx] == 3) {
				List<Edge> adjacent = tree.get(nodeIdx);
				for (Edge edge : adjacent) {
					if (inDegree[edge.dest] == 2) {
						if (!visited[edge.dest]) {
							answer.add(edge.idx);
							visited[edge.dest] = true;
						}
					} else {
						visited[edge.dest] = true;
					}
				}
			}
		}
		answer.sort(Comparator.naturalOrder());
		return answer.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}

	private static class Edge {
		private int idx;
		private int dest;

		public Edge(int idx, int dest) {
			this.idx = idx;
			this.dest = dest;
		}
	}
}
