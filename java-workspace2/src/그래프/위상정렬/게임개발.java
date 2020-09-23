package 그래프.위상정렬;


import java.util.*;

public class 게임개발 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfBuilding = scanner.nextInt();
		int[] inDegree = new int[countOfBuilding + 1];
		int[] cost = new int[countOfBuilding + 1];
		List<List<Integer>> adjacent = new ArrayList<>();
		for (int i = 0; i <= countOfBuilding; i++) {
			adjacent.add(new ArrayList<>());
		}
		for (int idx = 1; idx <= countOfBuilding; idx++) {
			cost[idx] = scanner.nextInt();
			while (true) {
				int preBuilding = scanner.nextInt();
				if (preBuilding == -1) {
					break;
				}
				adjacent.get(preBuilding).add(idx);
				inDegree[idx]++;
			}
		}
		sorting(adjacent, countOfBuilding, inDegree, cost);
	}

	private static void sorting(List<List<Integer>> adjacent, int countOfBuilding, int[] inDegree, int[] cost) {
		Queue<Building> queue = new PriorityQueue<>(Comparator.comparing(building -> building.end));
		int[] answer = new int[countOfBuilding + 1];
		for (int idx = 1; idx <= countOfBuilding; idx++) {
			if (inDegree[idx] == 0) {
				answer[idx] = cost[idx];
				queue.add(new Building(idx, cost[idx]));
			}
		}
		while (!queue.isEmpty()) {
			Building current = queue.poll();
			for (Integer adj : adjacent.get(current.idx)) {
				inDegree[adj]--;
				answer[adj] = current.end + cost[adj];
				if (inDegree[adj] == 0) {
					queue.add(new Building(adj, current.end + cost[adj]));
				}
			}
		}
		for (int idx = 1; idx <= countOfBuilding; idx++) {
			System.out.println(answer[idx]);
		}
	}

	private static class Building {
		private int idx;
		private int end;

		public Building(int idx, int end) {
			this.idx = idx;
			this.end = end;
		}
	}

}
