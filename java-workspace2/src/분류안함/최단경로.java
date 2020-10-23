package 분류안함;

import java.util.*;

public class 최단경로 {
	static Scanner scanner = new Scanner(System.in);
	static int countOfNode;
	static int countOfEdge;
	static List<Edge>[] edges;

	public static void main(String[] args) {
		countOfNode = scanner.nextInt();
		countOfEdge = scanner.nextInt();
		int start = scanner.nextInt();
		edges = new ArrayList[countOfNode + 1];
		for (int idx = 1; idx <= countOfNode; idx++) {
			edges[idx] = new ArrayList<>();
		}
		for (int idx = 0; idx < countOfEdge; idx++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			edges[source].add(new Edge(dest, cost));
		}
		solution(countOfNode, start);
	}

	private static void solution(int countOfNode, int start) {
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
		int[] distance = new int[countOfNode + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		distance[start] = 0;
		queue.add(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (distance[current.idx] < current.cost) {
				continue;
			}
			for (Edge edge : edges[current.idx]) {
				int cost = current.cost + edge.cost;
				if (distance[edge.dest] > cost) {
					distance[edge.dest] = cost;
					queue.add(new Node(edge.dest, cost));
				}
			}
		}
		for (int idx = 1; idx <= countOfNode; idx++) {
			System.out.println(distance[idx] == INF ? "INF" : distance[idx]);
		}
	}

	private static class Node {
		private int idx;
		private int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	private static class Edge {
		private int dest;
		private int cost;

		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
