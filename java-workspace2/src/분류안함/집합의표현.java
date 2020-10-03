package 분류안함;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 집합의표현 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int countOfNumber = input[0];
		int countOfOperation = input[1];
		int[] parents = new int[countOfNumber + 1];
		for (int idx = 0; idx <= countOfNumber; idx++) {
			parents[idx] = idx;
		}

		for (int idx = 0; idx < countOfOperation; idx++) {
			int[] operationInfo = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			operate(parents, operationInfo[0], operationInfo[1], operationInfo[2]);
		}
	}

	private static void operate(int[] parents, int operate, int a, int b) {
		if (operate == 0) {
			union(parents, a, b);
		} else {
			int parentOfA = find(parents, a);
			int parentOfB = find(parents, b);
			System.out.println(parentOfA == parentOfB ? "YES" : "NO");
		}
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
}
