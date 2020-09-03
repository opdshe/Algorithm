package 백준.시뮬레이션;


import java.util.Scanner;

public class 킹 {
	static Scanner scanner = new Scanner(System.in);
	static int kingY;
	static int kingX;
	static int rockY;
	static int rockX;
	static int N;

	public static void main(String[] args) {
		String[] inputs = scanner.nextLine().split(" ");
		initKing(inputs[0]);
		initRock(inputs[1]);
		N = Integer.parseInt(inputs[2]);
		for (int i = 0; i < N; i++) {
			move(scanner.nextLine());
		}
		System.out.println(convert(kingY, kingX));
		System.out.println(convert(rockY, rockX));

	}

	private static String convert(int y, int x) {
		return (char) (x + 65) + String.valueOf(8 - y);
	}

	private static void move(String order) {
		int[] offset = getOffset(order);
		int nextKingY = kingY + offset[0];
		int nextKingX = kingX + offset[1];

		int[] nextKingPosition = new int[]{nextKingY, nextKingX};
		int[] nextRockPosition = getNextRockPosition(nextKingY, nextKingX, order);

		if (isAvailablePosition(nextKingPosition) && isAvailablePosition(nextRockPosition)) {
			kingY = nextKingPosition[0];
			kingX = nextKingPosition[1];
			rockY = nextRockPosition[0];
			rockX = nextRockPosition[1];
		}
	}

	private static boolean isAvailablePosition(int[] position) {
		return position[0] >= 0 && position[0] < 8 &&
				position[1] >= 0 && position[1] < 8;
	}

	private static int[] getNextRockPosition(int nextKingY, int nextKingX, String order) {
		int[] offset = getOffset(order);
		if (rockY == nextKingY && rockX == nextKingX) {
			return new int[]{rockY + offset[0], rockX + offset[1]};
		} else {
			return new int[]{rockY, rockX};
		}
	}

	private static int[] getOffset(String order) {
		if (order.equals("R")) {
			return new int[]{0, 1};
		}
		if (order.equals("L")) {
			return new int[]{0, -1};
		}
		if (order.equals("B")) {
			return new int[]{1, 0};
		}
		if (order.equals("T")) {
			return new int[]{-1, 0};
		}
		if (order.equals("RT")) {
			return new int[]{-1, 1};
		}
		if (order.equals("LT")) {
			return new int[]{-1, -1};
		}
		if (order.equals("RB")) {
			return new int[]{1, 1};
		}
		return new int[]{1, -1};
	}

	private static void initRock(String position) {
		int[] ints = convertPosition(position);
		rockY = ints[0];
		rockX = ints[1];
	}

	private static void initKing(String position) {
		int[] ints = convertPosition(position);
		kingY = ints[0];
		kingX = ints[1];
	}

	private static int[] convertPosition(String position) {
		String[] input = position.split("");
		int x = (int) input[0].charAt(0) - 65;
		int y = 8 - Integer.parseInt(input[1]);
		return new int[]{y, x};
	}
}
