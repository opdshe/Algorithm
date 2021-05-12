package 기출.카카오인턴;

import java.util.*;

public class 사다시이 {
	private static List<Edge> edges = new ArrayList<>();
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3});
	}

	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
		init(n, roads);
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			int current = currentNode.idx;
			if (current == end) {
				answer = currentNode.cost;
				break;
			}
			if (isTrap(current, traps)) {
				for (Edge edge : edges) {
					if (edge.dest == current || edge.source == current) {
						edge.reverse = !edge.reverse;
					}
				}
			}
			for (Edge edge : edges) {
				if (edge.source == current && !edge.reverse) {
					queue.add(new Node(edge.dest, currentNode.cost + edge.cost));
				}
				if (edge.dest == current && edge.reverse) {
					queue.add(new Node(edge.source, currentNode.cost + edge.cost));
				}
			}
		}
		System.out.println(answer);
		return answer;
	}


	private static boolean isTrap(int current, int[] traps) {
		for (int trap : traps) {
			if (trap == current) {
				return true;
			}
		}
		return false;
	}


	private static void init(int n, int[][] roads) {
		for (int[] road : roads) {
			edges.add(new Edge(road[0], road[1], road[2]));
		}
	}

	private static class Edge {
		int source;
		int dest;
		int cost;
		boolean reverse;

		public Edge(int source, int dest, int cost) {
			this.source = source;
			this.dest = dest;
			this.cost = cost;
		}
	}

	private static class Node {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
