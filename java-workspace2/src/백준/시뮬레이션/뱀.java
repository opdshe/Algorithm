package 백준.시뮬레이션;

import java.util.*;

public class 뱀 {
	static int N;
	static int K;
	static int[][] board;
	static Deque<int[]> snake = new ArrayDeque<>();
	static char[] rotateTime = new char[10000];
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{0, 1},
			new int[]{1, 0},
			new int[]{0, -1}
	);
	//0 북, 1 동, 2 남, 3
	static int currentDirections = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();
		board = new int[N][N];
		snake.addLast(new int[]{0, 0});
		for (int i = 0; i < K; i++) {
			int row = scanner.nextInt() - 1;
			int column = scanner.nextInt() - 1;
			board[row][column] = 1;
		}
		int countOfRotate = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < countOfRotate; i++) {
			String[] inputs = scanner.nextLine().split(" ");
			int time = Integer.parseInt(inputs[0]);
			char directions = inputs[1].charAt(0);
			rotateTime[time] = directions;
		}
		solve();
	}

	private static void solve() {
		int time = 1;
		while (true) {
			if (!move()) {
				break;
			}
			if (rotateTime[time] != '\u0000') {
				rotate(rotateTime[time]);
			}
			time++;
		}
		System.out.println(time);
	}

	private static void rotate(char direction) {
		if (direction == 'D') {
			currentDirections = (currentDirections + 1) % 4;
		} else if (direction == 'L') {
			currentDirections = (currentDirections + 3) % 4;
		}
	}

	private static boolean move() {
		int[] offset = directions.get(currentDirections);
		int[] currentHead = snake.peekFirst();
		int[] nextHead = new int[]{currentHead[0] + offset[0], currentHead[1] + offset[1]};
		if (!isAvailablePosition(nextHead)) {
			return false;
		}
		snake.addFirst(nextHead);
		if (board[nextHead[0]][nextHead[1]] == 0) {
			int[] removePosition = snake.pollLast();
			board[removePosition[0]][removePosition[1]] = 0;
		}
		board[nextHead[0]][nextHead[1]] = 2;
		return true;
	}

	private static boolean isAvailablePosition(int[] nextHead) {
		return nextHead[0] >= 0 && nextHead[0] < N &&
				nextHead[1] >= 0 && nextHead[1] < N && board[nextHead[0]][nextHead[1]] != 2;
	}

}
