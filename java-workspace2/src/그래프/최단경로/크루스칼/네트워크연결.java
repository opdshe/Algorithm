package 그래프.최단경로.크루스칼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 네트워크연결 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfComputer = Integer.parseInt(bufferedReader.readLine());
		int countOfEdge = Integer.parseInt(bufferedReader.readLine());

		List<Edge> edges = new ArrayList<>();
		for (int edgeIdx = 0; edgeIdx < countOfEdge; edgeIdx++) {
			int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			edges.add(new Edge(edgeInfo[0], edgeInfo[1], edgeInfo[2]));
		}
		edges.sort(Comparator.comparing(edge -> edge.cost));
		solution(edges, countOfComputer);
	}

	private static void solution(List<Edge> edges, int countOfComputer) {
		int[] parents = new int[countOfComputer + 1];
		for (int idx = 1; idx <= countOfComputer; idx++) {
			parents[idx] = idx;
		}
		int count = 0;
		int cost = 0;
		for (Edge edge : edges) {
			if (find(parents, edge.source) != find(parents, edge.dest)) {
				union(parents, edge.source, edge.dest);
				count++;
				cost += edge.cost;
			}
			if (count == countOfComputer - 1) {
				break;
			}
		}
		System.out.println(cost);
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

	private static int find(int[] parents, int target) {
		if (parents[target] != target) {
			parents[target] = find(parents, parents[target]);
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
