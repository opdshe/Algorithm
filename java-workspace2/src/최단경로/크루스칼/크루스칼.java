package 최단경로.크루스칼;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 크루스칼 {
	/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
*/
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNode = scanner.nextInt();
		int countOfEdge = scanner.nextInt();
		List<Edge> edges = new ArrayList<>();
		int[] parents = new int[countOfNode + 1];
		for (int idx = 1; idx <= countOfNode; idx++) {
			parents[idx] = idx;
		}
		for (int i = 0; i < countOfEdge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			edges.add(new Edge(source, dest, cost));
		}
		edges.sort(Comparator.comparing((Edge e) -> e.cost));
		kruskal(edges, parents);
	}

	private static int kruskal(List<Edge> edges, int[] parents) {
		int cost = 0;
		for (Edge edge : edges) {
			if (getParent(parents, edge.source) != getParent(parents, edge.dest)) {
				union(parents, edge.source, edge.dest);
				cost += edge.cost;
			}
		}
		System.out.println(cost);
		return cost;
	}

	private static void union(int[] parents, int source, int dest) {
		int parentOfSource = getParent(parents, source);
		int parentOfDest = getParent(parents, dest);
		if (parentOfSource < parentOfDest) {
			parents[parentOfDest] = parentOfSource;
		} else {
			parents[parentOfSource] = parentOfDest;
		}
	}

	private static int getParent(int[] parents, int target) {
		if (parents[target] != target) {
			return getParent(parents, parents[target]);
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
