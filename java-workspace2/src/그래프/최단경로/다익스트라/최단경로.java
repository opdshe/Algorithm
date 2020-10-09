package 그래프.최단경로.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Map<Integer, List<Edge>> adjacent = new HashMap<>();
	static int INF = 0xfffffff;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int start = Integer.parseInt(bufferedReader.readLine());
		for (int idx = 1; idx <= input[0]; idx++) {
			adjacent.put(idx, new ArrayList<>());
		}
		//edge 초기화
		for (int idx = 0; idx < input[1]; idx++) {
			int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			List<Edge> adj = adjacent.getOrDefault(edgeInfo[0], new ArrayList<>());
			adj.add(new Edge(edgeInfo[1], edgeInfo[2]));
			adjacent.put(edgeInfo[0], adj);
		}

		dijkstra(input[0], start);
	}

	private static void dijkstra(int countOfNode, int start) {
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
		queue.add(new Node(start, 0));
		int[] distance = new int[countOfNode + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (distance[current.idx] < current.cost) {
				continue;
			}
			for (Edge edge : adjacent.get(current.idx)) {
				int cost = current.cost + edge.cost;
				if (distance[edge.dest] > cost) {
					distance[edge.dest] = cost;
					queue.add(new Node(edge.dest, cost));
				}
			}
		}

		//출력
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
