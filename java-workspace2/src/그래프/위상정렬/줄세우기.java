package 그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄세우기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int[] inDegree;
	static int countOfStudent;
	static List<List<Integer>> adjacent = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		countOfStudent = input[0];
		for (int i = 0; i < countOfStudent + 1; i++) {
			adjacent.add(new ArrayList<>());
		}
		inDegree = new int[countOfStudent + 1];
		for (int i = 0; i < input[1]; i++) {
			int[] order = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			int from = order[0];
			int to = order[1];
			inDegree[to]++;
			adjacent.get(from).add(to);
		}
		search();
	}

	private static void search() {
		Queue<Integer> queue = new ArrayDeque<>();
		for (int idx = 1; idx <= countOfStudent; idx++) {
			if (inDegree[idx] == 0) {
				queue.add(idx);
			}
		}
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			System.out.print(current + " ");
			for (Integer adj : adjacent.get(current)) {
				inDegree[adj]--;
				if (inDegree[adj] == 0) {
					queue.add(adj);
				}
			}
		}
	}
}
