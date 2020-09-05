package 백준.트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 트리의부모찾기 {
	static int N;
	static int[] parents;
	static Scanner scanner = new Scanner(System.in);
	static List<int[]> orders = new ArrayList<>();

	public static void main(String[] args) {
		N = scanner.nextInt();
		scanner.nextLine();
		parents = new int[N + 1];
		parents[1] = 1;
		for (int i = 0; i < N - 1; i++) {
			int[] inputs = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			orders.add(inputs);
		}
		pair();
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}

	private static void pair() {
		parents[1] = 1;
		int count = 0;
		while (count < N - 1) {
			for (int i = 0; i < orders.size(); i++) {
				int[] order = orders.get(i);
				if (parents[order[0]] != 0) {
					count++;
					parents[order[1]] = order[0];
				} else if (parents[order[1]] != 0) {
					parents[order[0]] = order[1];
					count++;
				}
			}
		}
	}
}
