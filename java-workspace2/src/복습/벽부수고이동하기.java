package 복습;

import java.util.*;

public class 벽부수고이동하기 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;
	static int[][] map;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		map = new int[maxRow][maxColumn];
		scanner.nextLine();
		for (int row = 0; row < maxRow; row++) {
			map[row] = Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		solution();
	}

	private static void solution() {
		boolean[][][] visited = new boolean[maxRow][maxColumn][2];
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;

		int answer = -1;
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.y == maxRow - 1 && current.x == maxColumn - 1) {
				answer = current.cost;
				break;
			}
			for (int[] direction : directions) {
				int nextRow = current.y + direction[0];
				int nextColumn = current.x + direction[1];
				if (isAvailablePosition(nextRow, nextColumn)) {
					if (map[nextRow][nextColumn] == 0 && !visited[nextRow][nextColumn][current.destroy]) {
						visited[nextRow][nextColumn][current.destroy] = true;
						queue.add(new Node(nextRow, nextColumn, current.cost + 1, current.destroy));
					} else if (map[nextRow][nextColumn] == 1) {
						if (current.destroy == 0 && !visited[nextRow][nextColumn][1]) {
							visited[nextRow][nextColumn][1] = true;
							queue.add(new Node(nextRow, nextColumn, current.cost + 1, 1));
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}

	private static class Node {
		int y;
		int x;
		int cost;
		int destroy;

		public Node(int y, int x, int cost, int destroy) {
			this.y = y;
			this.x = x;
			this.cost = cost;
			this.destroy = destroy;
		}
	}
}
