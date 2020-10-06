package 그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제집 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int countOfProblem = input[0];
		int countOfOrder = input[1];
		List<List<Integer>> adjacent = new ArrayList<>();
		for (int idx = 0; idx <= countOfProblem; idx++) {
			adjacent.add(new ArrayList<>());
		}
		int[] inDegree = new int[countOfProblem + 1];
		for (int orderIdx = 0; orderIdx < countOfOrder; orderIdx++) {
			int[] orderInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			inDegree[orderInfo[1]]++;
			adjacent.get(orderInfo[0]).add(orderInfo[1]);
		}

		solution(adjacent, inDegree, countOfProblem);
	}

	private static void solution(List<List<Integer>> adjacent, int[] inDegree, int countOfProblem) {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int idx = 1; idx <= countOfProblem; idx++) {
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