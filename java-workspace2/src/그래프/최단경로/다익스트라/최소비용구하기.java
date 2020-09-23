package 그래프.최단경로.다익스트라;

import java.util.*;

public class 최소비용구하기 {
	static Scanner scanner = new Scanner(System.in);
	static Map<Integer, List<Route>> adjacent = new HashMap<>();

	public static void main(String[] args) {
		int vertex = scanner.nextInt();
		int edge = scanner.nextInt();
		for (int i = 1; i <= vertex; i++) {
			adjacent.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int weight = scanner.nextInt();
			List<Route> adj = adjacent.getOrDefault(source, new ArrayList<>());
			adj.add(new Route(dest, weight));
			adjacent.put(source, adj);
		}
		int source = scanner.nextInt();
		int dest = scanner.nextInt();
		dijkstra(source, dest, vertex);
	}

	private static int dijkstra(int source, int dest, int vertex) {
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node n) -> n.cost));
		int[] distance = new int[vertex + 1];
		int INF = 0xfffffff;
		Arrays.fill(distance, INF);
		distance[source] = 0;
		queue.add(new Node(source, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (distance[current.idx] < current.cost) {
				continue;
			}
			for (Route route : adjacent.get(current.idx)) {
				int cost = distance[current.idx] + route.weight;
				if (distance[route.dest] > cost) {
					distance[route.dest] = cost;
					queue.add(new Node(route.dest, cost));
				}
			}
		}
		System.out.println(distance[dest]);
		return distance[dest];
	}

	private static class Node {
		private int idx;
		private int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	private static class Route {
		private int dest;
		private int weight;

		public Route(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
}
