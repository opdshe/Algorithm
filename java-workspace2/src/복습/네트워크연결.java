package 복습;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 네트워크연결 {
	static Scanner scanner = new Scanner(System.in);
	static List<Edge> edges = new ArrayList<>();

	public static void main(String[] args) {
		int countOfComputers = scanner.nextInt();
		int[] parents = initParents(countOfComputers);
		int countOfConnections = scanner.nextInt();
		for (int i = 0; i < countOfConnections; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			edges.add(new Edge(source, dest, cost));
		}
		edges.sort(Comparator.comparing(edge -> edge.cost));
		solution(parents, countOfComputers);
	}

	private static void solution(int[] parents, int countOfComputer) {
		int count = 0;
		int cost = 0;
		for (Edge edge : edges) {
			if (count == countOfComputer - 1) {
				break;
			}
			int source = find(parents, edge.source);
			int dest = find(parents, edge.dest);
			if (source != dest) {
				union(parents, source, dest);
				cost += edge.cost;
				count++;
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


	private static int[] initParents(int countOfComputers) {
		int[] parents = new int[countOfComputers + 1];
		for (int idx = 1; idx <= countOfComputers; idx++) {
			parents[idx] = idx;
		}
		return parents;
	}

	private static class Edge {
		int source;
		int dest;
		int cost;

		public Edge(int source, int dest, int cost) {
			this.source = source;
			this.dest = dest;
			this.cost = cost;
		}
	}
}
