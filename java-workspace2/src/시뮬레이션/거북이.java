package 시뮬레이션;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 거북이 {
	static Scanner scanner = new Scanner(System.in);
	static Map<Integer, int[]> directions = new HashMap<>();

	public static void main(String[] args) {
		initDirections();
		int testcase = scanner.nextInt();
		scanner.nextLine();
		for (int test = 0; test < testcase; test++) {
			String[] order = Arrays.stream(scanner.nextLine().split(""))
					.toArray(String[]::new);
			operate(order);
		}
	}

	private static void initDirections() {
		directions.put(0, new int[]{-1, 0});
		directions.put(1, new int[]{0, 1});
		directions.put(2, new int[]{1, 0});
		directions.put(3, new int[]{0, -1});
	}

	private static void operate(String[] order) {
		int minX = 0;
		int maxX = 0;
		int minY = 0;
		int maxY = 0;
		Turtle turtle = new Turtle(0, 0, 0);
		for (String s : order) {
			if (s.equals("F")) {
				turtle.go();
			} else if (s.equals("B")) {
				turtle.back();
			} else if (s.equals("L")) {
				turtle.rotate(3);
			} else if (s.equals("R")) {
				turtle.rotate(1);
			}
			minX = Math.min(minX, turtle.x);
			maxX = Math.max(maxX, turtle.x);
			minY = Math.min(minY, turtle.y);
			maxY = Math.max(maxY, turtle.y);
		}

		System.out.println(Math.abs(maxY - minY) * Math.abs(maxX - minX));
	}

	private static class Turtle {
		private int y;
		private int x;
		private int dir;

		public Turtle(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		private void rotate(int offset) {
			this.dir = ((dir + offset) % 4);

		}

		private void go() {
			this.y = y + directions.get(this.dir)[0];
			this.x = x + directions.get(this.dir)[1];
		}

		private void back() {
			this.y = y - (directions.get(this.dir)[0]);
			this.x = x - (directions.get(this.dir)[1]);
		}
	}
}
