package 그래프.최단경로.다익스트라;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<List<Road>> adjacent = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		String[] input = bufferedReader.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int X = Integer.parseInt(input[2]);
		for (int i = 0; i <= N; i++) {
			adjacent.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int[] roadInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			adjacent.get(roadInfo[0]).add(new Road(roadInfo[1], roadInfo[2]));
		}
		search(N, X);
	}

	private static int search(int N, int X) {
		int max = -1;
		for (int i = 1; i <= N; i++) {
			int go = dijkstra(i, X, N);
			int back = dijkstra(X, i, N);
			if (go + back < 0xfffffff) {
				max = Math.max(max, go + back);
			}
		}
		System.out.println(max);
		return max;
	}

	private static int dijkstra(int source, int dest, int N) {
		int[] distance = new int[N + 1];
		int INF = 0xfffffff;
		Arrays.fill(distance, INF);
		distance[source] = 0;
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node n) -> n.cost));
		queue.add(new Node(source, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (distance[current.idx] < current.cost) {
				continue;
			}
			for (Road road : adjacent.get(current.idx)) {
				int cost = current.cost + road.cost;
				if (distance[road.dest] > cost) {
					distance[road.dest] = cost;
					queue.add(new Node(road.dest, cost));
				}
			}
		}
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

	private static class Road {
		private int dest;
		private int cost;

		public Road(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
