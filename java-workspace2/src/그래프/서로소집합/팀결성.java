package 그래프.서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 팀결성 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int N = input[0];
		int M = input[1];
		int[] parents = new int[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			parents[idx] = idx;
		}
		for (int idx = 0; idx < M; idx++) {
			int[] order = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			operate(parents, order);
		}
	}

	private static void operate(int[] parents, int[] order) {
		if (order[0] == 0) {
			union(parents, order[1], order[2]);
		} else {
			if (getParents(parents, order[1]) == getParents(parents, order[2])) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static void union(int[] parents, int a, int b) {
		int parentOfA = getParents(parents, a);
		int parentOfB = getParents(parents, b);
		if (parentOfA < parentOfB) {
			parents[parentOfB] = parentOfA;
		} else {
			parents[parentOfA] = parentOfB;
		}
	}

	private static int getParents(int[] parents, int target) {
		if (parents[target] != target) {
			return getParents(parents, parents[target]);
		}
		return parents[target];
	}
}
