package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 중량제한 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Map<Integer, List<Edge>> adjacent = new HashMap<>();

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int idx = 1; idx <= input[0]; idx++) {
			adjacent.put(idx, new ArrayList<>());
		}
		for (int idx = 1; idx <= input[1]; idx++) {
			int[] bridgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			List<Edge> sourceAdjacent = adjacent.get(bridgeInfo[0]);
			List<Edge> destAdjacent = adjacent.get(bridgeInfo[1]);
			sourceAdjacent.add(new Edge(bridgeInfo[1], bridgeInfo[2]));
			destAdjacent.add(new Edge(bridgeInfo[0], bridgeInfo[2]));
			adjacent.put(bridgeInfo[0], sourceAdjacent);
			adjacent.put(bridgeInfo[1], destAdjacent);
		}
		int[] target = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		solution(input[0], target);
	}

	private static void solution(int countOfPlace, int[] target) {
		int answer = 0;
		Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.cost < o2.cost) {
					return 1;
				}
				return -1;
			}
		});
		queue.add(new Node(target[0], Integer.MAX_VALUE));
		int[] costs = new int[countOfPlace + 1];
		Arrays.fill(costs, -1);
		costs[target[0]] = 0;


		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (costs[current.idx] > current.cost) {
				continue;
			}
			if (current.idx == target[1]) {
				answer = current.cost;
			}
			//System.out.println(current.idx +" , " + current.cost);
			for (Edge edge : adjacent.get(current.idx)) {
				int cost = Math.min(current.cost, edge.cost);
				if (costs[edge.dest] < cost) {
					costs[edge.dest] = cost;
					queue.add(new Node(edge.dest, cost));
				}
			}
		}
		System.out.println(answer);
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
