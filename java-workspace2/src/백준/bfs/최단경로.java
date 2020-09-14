package 백준.bfs;


import java.util.*;

public class 최단경로 {
	static boolean[] visited;
	static int[] distance;
	static Map<Integer, List<Node>> adj = new HashMap<>();
	static int countOfVertex;
	static int countOfEdge;
	static int start;
	static int maxValue;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		countOfVertex = scanner.nextInt();
		countOfEdge = scanner.nextInt();
		visited = new boolean[countOfVertex + 1];
		distance = new int[countOfVertex + 1];
		maxValue = 10 * countOfVertex;
		Arrays.fill(distance, maxValue);
		start = scanner.nextInt();
		for (int i = 1; i <= countOfVertex; i++) {
			adj.put(i, new ArrayList<>());
		}
		for (int i = 0; i < countOfEdge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int weight = scanner.nextInt();
			List<Node> nodes = adj.getOrDefault(source, new ArrayList<>());
			nodes.add(new Node(dest, weight));
			adj.put(source, nodes);
		}
		search(start);
	}

	private static void search(int start) {
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node n) -> n.weight));
		queue.add(new Node(start, 0));
		distance[start] = 0;

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (visited[current.idx]) {
				continue;
			}
			visited[current.idx] = true;
			for (Node adjNode : adj.get(current.idx)) {
				if (!visited[adjNode.idx] && distance[adjNode.idx] > distance[current.idx] + adjNode.weight) {
					distance[adjNode.idx] = distance[current.idx] + adjNode.weight;
					queue.add(new Node(adjNode.idx, distance[current.idx] + adjNode.weight));
				}
			}
		}
		print();
	}

	private static void print() {
		for (int i = 1; i <= countOfVertex; i++) {
			if (distance[i] == maxValue) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}

	private static class Node {
		private int idx;
		private int weight;

		private Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}

}
