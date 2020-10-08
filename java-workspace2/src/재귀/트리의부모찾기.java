package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 트리의부모찾기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfNode = Integer.parseInt(bufferedReader.readLine());
		int[] parents = new int[countOfNode + 1];
		parents[1] = 1;
		List<List<Integer>> adjacent = new ArrayList<>();
		for (int idx = 0; idx <= countOfNode; idx++) {
			adjacent.add(new ArrayList<>());
		}
		for (int idx = 0; idx < countOfNode - 1; idx++) {
			int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			adjacent.get(input[0]).add(input[1]);
			adjacent.get(input[1]).add(input[0]);
		}
		boolean[] visited = new boolean[countOfNode + 1];
		dfs(adjacent, parents, visited, 1);
		for (int idx = 2; idx <= countOfNode; idx++) {
			System.out.println(parents[idx]);
		}
	}

	private static void dfs(List<List<Integer>> adjacent, int[] parents, boolean[] visited, int current) {
		visited[current] = true;
		if (parents[current] != 0) {
			for (Integer integer : adjacent.get(current)) {
				if (!visited[integer]) {
					parents[integer] = current;
					dfs(adjacent, parents, visited, integer);
				}
			}
		}
	}
}
