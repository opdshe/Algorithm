package 백준.시뮬레이션;

import java.util.*;

public class 아기상어 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int[] sharkPosition;
	static int sharkSize = 1;
	static int[][] map;
	static int[][] visited;
	static int[] fishInfo = new int[7];
	static List<int[]> directions = Arrays.asList(
			new int[]{1, 0},
			new int[]{-1, 0},
			new int[]{0, 1},
			new int[]{0, -1}
	);

	public static void main(String[] args) {
		init();
		solve();
	}

	private static void solve() {
		int time = 0;
		while (true) {
			int countOfEatableFish = getCountOfEatableFish();
			if (countOfEatableFish == 0) {
				break;
			} else if (countOfEatableFish == 1) {
				bfs();
			}
		}

	}

	private static int[] bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(sharkPosition);
		int[] nextFish = new int[2];
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (map[current[0]][current[1]] > 0) {
				nextFish = current;
				break;
			}
			for (int[] offset : directions) {
				int[] nextPosition = new int[]{current[0] + offset[0], current[1 + offset[1]]};
				if (isAvailablePosition(nextPosition) && visited[nextPosition[0]][nextPosition[1]] == 0) {
					visited[nextPosition[0]][nextPosition[1]] = visited[current[0]][current[1]] + 1;
					queue.add(nextPosition);
				}
			}

		}
		visited = new int[N][N];
		return nextFish;
	}

	private static boolean isAvailablePosition(int[] nextPosition) {
		return nextPosition[0] >= 0 && nextPosition[0] < N &&
				nextPosition[1] >= 0 && nextPosition[1] < N &&
				map[nextPosition[0]][nextPosition[1]] <= sharkSize;
	}


	private static void init() {
		N = scanner.nextInt();
		scanner.nextLine();
		map = new int[N][N];
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = scanner.nextInt();
				if (size == 9) {
					sharkPosition = new int[]{i, j};
				} else {
					if (size == 0) {
						continue;
					}
					fishInfo[size]++;
				}
			}
		}
		System.out.println(Arrays.toString(fishInfo));
	}

	private static int getCountOfEatableFish() {
		int count = 0;
		for (int i = 1; i < sharkSize; i++) {
			if (fishInfo[i] > 0) {
				count++;
			}
		}
		return count;
	}
}
