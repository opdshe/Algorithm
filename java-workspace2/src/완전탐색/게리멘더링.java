package 완전탐색;

import java.util.*;
//1~ n/2구역 분할
//최소 차이 구하


public class 게리멘더링 {
	static Scanner scanner = new Scanner(System.in);
	static int totalSum = 0;
	static int answer = Integer.MAX_VALUE;
	static List<List<Integer>> adjacent = new ArrayList<>();

	public static void main(String[] args) {
		int countOfNode = scanner.nextInt();
		int[] countOfPeople = new int[countOfNode + 1];
		for (int idx = 1; idx <= countOfNode; idx++) {
			int value = scanner.nextInt();
			countOfPeople[idx] = value;
			totalSum += value;
		}
		adjacent.add(new ArrayList<>());
		for (int idx = 1; idx <= countOfNode; idx++) {
			adjacent.add(new ArrayList<>());
			int countOfAdjacent = scanner.nextInt();
			for (int i = 0; i < countOfAdjacent; i++) {
				adjacent.get(idx).add(scanner.nextInt());
			}
		}
		solution(countOfPeople, countOfNode);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	private static boolean isConnected(List<Integer> target, int countOfNode) {
		if (target.size() == 1) {
			return true;
		}
		boolean[] visited = new boolean[countOfNode + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(target.get(0));
		visited[target.get(0)] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			count++;
			for (Integer adj : adjacent.get(current)) {
				if (!visited[adj] && target.contains(adj)) {
					visited[adj] = true;
					queue.add(adj);
				}
			}
		}
		return count == target.size();
	}


	private static void solution(int[] countOfPeople, int countOfNode) {
		for (int size = 1; size <= countOfNode / 2; size++) {
			int[] array = new int[size];
			dfs(countOfPeople, countOfNode, array, 1, 0, size);
		}
	}


	private static void dfs(int[] countOfPeople, int countOfNode, int[] array, int start, int level, int size) {
		if (level == size) {
			System.out.println(Arrays.toString(array));
			List<Integer> target = new ArrayList<>();
			for (int idx = 0; idx < size; idx++) {
				target.add(array[idx]);
			}
			if (isConnected(target, countOfNode)) {
				System.out.println("connected");
				int targetSum = 0;
				for (Integer integer : target) {
					targetSum += countOfPeople[integer];
				}
				int otherSum = totalSum - targetSum;
				int gap = Math.abs(targetSum - otherSum);
				answer = Math.min(answer, gap);
			}
			return;
		}
		for (int idx = start; idx <= countOfNode; idx++) {
			array[level] = idx;
			dfs(countOfPeople, countOfNode, array, idx + 1, level + 1, size);
		}
	}
}