package 그래프.위상정렬;

import java.util.*;

public class 음악프로그램 {
	static Scanner scanner = new Scanner(System.in);
	static int countOfSinger;
	static int countOfPd;
	static int[] inDegree;
	static List<List<Integer>> adjacent = new ArrayList<>();


	public static void main(String[] args) {
		countOfSinger = scanner.nextInt();
		countOfPd = scanner.nextInt();
		scanner.nextLine();
		inDegree = new int[countOfSinger + 1];
		for (int i = 0; i < countOfSinger + 1; i++) {
			adjacent.add(new ArrayList<>());
		}
		for (int i = 1; i <= countOfPd; i++) {
			int[] input = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			for (int idx = 2; idx <= input.length - 1; idx++) {
				adjacent.get(input[idx - 1]).add(input[idx]);
				inDegree[input[idx]]++;
			}
		}
		solve();
	}

	private static void solve() {
		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> answer = new ArrayDeque<>();
		for (int i = 1; i <= countOfSinger; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
		int count = 0;
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			answer.add(current);
			count++;
			for (Integer adj : adjacent.get(current)) {
				inDegree[adj]--;
				if (inDegree[adj] == 0) {
					queue.add(adj);
				}
			}
		}
		if (count == countOfSinger) {
			while (!answer.isEmpty()) {
				System.out.println(answer.poll());
			}
		} else {
			System.out.println(0);
		}
	}
}
