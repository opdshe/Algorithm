package 시뮬레이션;

import java.util.*;

public class 경쟁적전염 {
	static Scanner scanner = new Scanner(System.in);
	static Queue<Virus> viruses = new PriorityQueue<Virus>((Virus a, Virus b) -> {
		if (a.time > b.time) {
			return 1;
		} else if (a.time == b.time) {
			if (a.num > b.num) {
				return 1;
			}
		}
		return -1;
	});
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int[][] map = new int[N + 1][N + 1];
		for (int height = 1; height <= N; height++) {
			for (int width = 1; width <= N; width++) {
				map[height][width] = scanner.nextInt();
				if (map[height][width] != 0) {
					viruses.add(new Virus(map[height][width], height, width, 0));
				}
			}
		}
		int S = scanner.nextInt();
		int Y = scanner.nextInt();
		int X = scanner.nextInt();
		search(map, N, S, Y, X);
	}

	private static void search(int[][] map, int N, int S, int Y, int X) {
		while (!viruses.isEmpty()) {
			Virus current = viruses.poll();
			if (current.time == S) {
				break;
			}
			for (int[] direction : directions) {
				int nextHeight = current.y + direction[0];
				int nextWidth = current.x + direction[1];
				if (isAvailablePoint(N, nextHeight, nextWidth)) {
					if (map[nextHeight][nextWidth] == 0) {
						map[nextHeight][nextWidth] = current.num;
						viruses.add(new Virus(current.num, nextHeight, nextWidth, current.time + 1));
					}
				}
			}
		}
		System.out.println(map[Y][X]);
	}


	private static class Virus {
		private int num;
		private int y;
		private int x;
		private int time;

		public Virus(int num, int y, int x, int time) {
			this.num = num;
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}

	private static boolean isAvailablePoint(int N, int nextHeight, int nextWidth) {
		return nextHeight >= 1 && nextHeight <= N &&
				nextWidth >= 1 && nextWidth <= N;
	}
}
