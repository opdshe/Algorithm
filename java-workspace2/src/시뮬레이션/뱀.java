package 시뮬레이션;

import java.util.*;

public class 뱀 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;
	static Map<Integer, int[]> directions = new HashMap<>();
	static int direction = 1;
	static Deque<int[]> snake = new ArrayDeque<>();
	static Queue<Order> orders = new ArrayDeque<>();


	public static void main(String[] args) {
		initDirections();
		size = scanner.nextInt();
		map = new int[size + 1][size + 1];
		int countOfApple = scanner.nextInt();
		for (int idx = 0; idx < countOfApple; idx++) {
			int y = scanner.nextInt();
			int x = scanner.nextInt();
			map[y][x] = 1;
		}
		int countOfOrder = scanner.nextInt();
		scanner.nextLine();
		for (int idx = 0; idx < countOfOrder; idx++) {
			String[] order = scanner.nextLine().split(" ");
			orders.add(new Order(Integer.parseInt(order[0]), order[1]));
		}
		play();
	}

	private static void play() {
		int time = 1;
		snake.addLast(new int[]{1, 1});
		while (true) {
			int[] offset = directions.get(direction);
			int nextRow = snake.peekLast()[0] + offset[0];
			int nextColumn = snake.peekLast()[1] + offset[1];
			if (isAvailablePosition(nextRow, nextColumn) && !alreadyContains(nextRow, nextColumn)) {
				snake.addLast(new int[]{nextRow, nextColumn});
				if (map[nextRow][nextColumn] == 1) {
					map[nextRow][nextColumn] = 0;
				} else {
					snake.pollFirst();
				}
			} else {
				break;
			}
			if (!orders.isEmpty()) {
				if (orders.peek().time == time) {
					Order order = orders.poll();
					if (order.dir.equals("L")) {
						direction = (direction + 3) % 4;
					} else {
						direction = (direction + 1) % 4;
					}
				}
			}
			time++;
		}
		System.out.println(time);
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 1 && nextRow <= size &&
				nextColumn >= 1 && nextColumn <= size;
	}

	private static boolean alreadyContains(int nextRow, int nextColumn) {
		boolean contains = false;
		for (int[] ints : snake) {
			if (ints[0] == nextRow && ints[1] == nextColumn) {
				contains = true;
				break;
			}
		}
		return contains;
	}

	private static void initDirections() {
		directions.put(0, new int[]{-1, 0});
		directions.put(1, new int[]{0, 1});
		directions.put(2, new int[]{1, 0});
		directions.put(3, new int[]{0, -1});
	}

	private static class Order {
		private int time;
		private String dir;

		public Order(int time, String dir) {
			this.time = time;
			this.dir = dir;
		}
	}
}
