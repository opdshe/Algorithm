package 그래프.최단경로.크루스칼;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 최소스패닝트리 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue<Edge> edges = new PriorityQueue<>(Comparator.comparing(edge -> edge.cost));
		int countOfVertex = scanner.nextInt();
		int[] parents = new int[countOfVertex + 1];
		for (int idx = 1; idx <= countOfVertex; idx++) {
			parents[idx] = idx;
		}
		int countOfEdge = scanner.nextInt();
		for (int count = 0; count < countOfEdge; count++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			edges.add(new Edge(source, dest, cost));
		}

		long cost = 0;
		while (!edges.isEmpty()) {
			Edge edge = edges.poll();
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
