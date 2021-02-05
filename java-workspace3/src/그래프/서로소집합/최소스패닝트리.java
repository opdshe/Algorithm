package 그래프.서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 최소스패닝트리 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<Edge> edges = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int idx = 0; idx < input[1]; idx++) {
			edges.add(new Edge(bufferedReader.readLine().split(" ")));
		}
		edges.sort(Comparator.comparing(edge -> edge.cost));
		int[] parents = new int[input[0] + 1];
		for (int idx = 1; idx <= input[0]; idx++) {
			parents[idx] = idx;
		}
		int answer = 0;
		for (Edge edge : edges) {
			int parentOfSource = find(parents, edge.source);
			int parentOfDest = find(parents, edge.dest);
			if (parentOfSource != parentOfDest) {
				union(parents, edge.source, edge.dest);
				answer += edge.cost;
			}
		}
		System.out.println(answer);
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
		int source;
		int dest;
		int cost;

		public Edge(String[] info) {
			source = Integer.parseInt(info[0]);
			dest = Integer.parseInt(info[1]);
			cost = Integer.parseInt(info[2]);
		}
	}
}
