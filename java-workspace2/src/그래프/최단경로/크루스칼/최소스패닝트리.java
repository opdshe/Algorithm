package 그래프.최단경로.크루스칼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 최소스패닝트리 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<Edge> edges = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int countOfVertex = input[0];
		int[] parents = new int[countOfVertex + 1];
		for (int idx = 1; idx <= countOfVertex; idx++) {
			parents[idx] = idx;
		}
		int countOfEdge = input[1];
		for (int count = 0; count < countOfEdge; count++) {
			int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			int source = edgeInfo[0];
			int dest = edgeInfo[1];
			int cost = edgeInfo[2];
			edges.add(new Edge(source, dest, cost));
		}
		edges.sort(Comparator.comparing(edge -> edge.cost));
		kruskal(edges, parents);
	}

	private static void kruskal(List<Edge> edges, int[] parents) {
		long cost = 0;
		for (Edge edge : edges) {
			if (find(parents, edge.source) != find(parents, edge.dest)) {
				union(parents, edge.source, edge.dest);
				cost += edge.cost;
			}
		}
		System.out.println(cost);
	}


	private static int find(int[] parents, int target) {
		if (parents[target] != target) {
			parents[target] = find(parents, parents[target]);
		}
		return parents[target];
	}

	private static void union(int[] parents, int a, int b) {
		int parentOfA = find(parents, a);
		int parentOfB = find(parents, b);
		if (parentOfA < parentOfB) {
			parents[parentOfB] = parentOfA;
		} else {
			parents[parentOfA] = parentOfB;
		}
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
