package 기출.라인2020;


import java.util.ArrayDeque;
import java.util.Queue;

public class 일번 {
	public static void main(String[] args) {
		solution(new int[][]{
				{0, 1, 0, 1},
				{0, 1, 0, 0},
				{0, 0, 0, 0},
				{1, 0, 1, 0}
		});
	}

	public static int solution(int[][] maze) {
		bfs(maze);
		return 0;
	}

	private static void bfs(int[][] maze) {
		Queue<Position> queue = new ArrayDeque<>();
		queue.add(new Position(0, 0, 0));
	}

	private static class Position {
		private int y;
		private int x;
		private int distance;

		public Position(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
	}
}