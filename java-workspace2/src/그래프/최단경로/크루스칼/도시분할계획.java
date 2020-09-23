package 그래프.최단경로.크루스칼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 도시분할계획 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		List<Edge> edges = new ArrayList<>();
		int[] parents = new int[input[0] + 1];
		for (int idx = 1; idx <= input[0]; idx++) {
			parents[idx] = idx;
		}
		for (int i = 0; i < input[1]; i++) {
			int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			edges.add(new Edge(edgeInfo[0], edgeInfo[1], edgeInfo[2]));
		}
		edges.sort(Comparator.comparing((edge -> edge.cost)));
		kruskal(edges, parents);
	}

	private static int kruskal(List<Edge> edges, int[] parents) {
		int maxCost = 0;
		int result = 0;
		for (Edge edge : edges) {
			if (getParents(parents, edge.source) == getParents(parents, edge.dest)) {
				//사이클 존재
				continue;
			}
			union(parents, edge.source, edge.dest);
			result += edge.cost;
			maxCost = Math.max(maxCost, edge.cost);
		}
		result -= maxCost;
		System.out.println(result);
		return result;
	}

	private static boolean union(int[] parents, int a, int b) {
		int parentOfA = getParents(parents, a);
		int parentOfB = getParents(parents, b);
		if (parentOfA == parentOfB) {
			return true;
		} else if (parentOfA < parentOfB) {
			parents[parentOfB] = parentOfA;
			return false;
		} else {
			parents[parentOfA] = parentOfB;
			return false;
		}
	}

	private static int getParents(int[] parents, int target) {
		if (parents[target] != target) {
			return getParents(parents, parents[target]);
		}
		return parents[target];
	}

	private static class Edge {
		private int source;
		private int dest;
		private int cost;

		public Edge(int source, int dest, int cost) {
			this.source = source;
			this.dest = dest;
			this.cost = cost;
		}
	}
}
