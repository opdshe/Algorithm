package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 이분그래프 {
	static boolean available = true;
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(bufferedReader.readLine());
		for (int test = 0; test < testcase; test++) {
			available = true;
			int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			int countOfNode = input[0];
			int countOfEdge = input[1];

			Node[] nodes = new Node[countOfNode + 1];
			for (int idx = 1; idx <= countOfNode; idx++) {
				nodes[idx] = new Node(idx);
			}
			for (int edgeCount = 1; edgeCount <= countOfEdge; edgeCount++) {
				int[] edgeIfo = Arrays.stream(bufferedReader.readLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();
				nodes[edgeIfo[0]].adjacent.add(edgeIfo[1]);
				nodes[edgeIfo[1]].adjacent.add(edgeIfo[0]);
			}

			boolean[] visited = new boolean[countOfNode + 1];
			for (int idx = 1; idx <= countOfNode; idx++) {
				if (!visited[idx]) {
					if (!available) {
						break;
					}
					dfs(nodes, visited, idx, 1);
				}
			}
			System.out.println(available ? "YES" : "NO");
		}
	}

	private static void dfs(Node[] nodes, boolean[] visited, int current, int flag) {
		visited[current] = true;
		nodes[current].flag = flag;
		//System.out.println("visited" + current);
		for (Integer adjacent : nodes[current].adjacent) {
			if (!visited[adjacent]) {
				dfs(nodes, visited, adjacent, -flag);
			} else {
				if (nodes[adjacent].flag == flag) {
					available = false;
					return;
				}
			}
		}
	}

	private static class Node {
		private int idx;

		private int flag = 0;

		private List<Integer> adjacent = new ArrayList<>();

		public Node(int idx) {
			this.idx = idx;
		}
	}
}
