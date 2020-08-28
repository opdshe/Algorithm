package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 톱니바퀴 {
	static int N;
	static Topny[] topny = new Topny[5];
	static int[] topnyDirections = new int[5];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 1; i <= 4; i++) {
			topny[i] = new Topny(Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray());
		}
		N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int target = scanner.nextInt();
			int direction = scanner.nextInt();
			operate(target, direction);
		}
		totalScore();
	}

	private static void operate(int target, int direction) {
		topnyDirections[target] = direction;
		int targetLeft = topny[target].topny.get(0);
		int leftDirection = -direction;
		int targetRight = topny[target].topny.get(4);
		int rightDirection = -direction;
		for (int i = target - 1; i >= 1; i--) {
			if (topny[i].topny.get(4) == targetLeft) {
				break;
			}
			topnyDirections[i] = leftDirection;
			targetLeft = topny[i].topny.get(0);
			leftDirection = -leftDirection;
		}

		for (int i = target + 1; i <= 4; i++) {
			if (topny[i].topny.get(0) == targetRight) {
				break;
			}
			topnyDirections[i] = rightDirection;
			targetRight = topny[i].topny.get(4);
			rightDirection = -rightDirection;
		}
		System.out.println(Arrays.toString(topnyDirections));
		for (int i = 1; i <= 4; i++) {
			topny[i].rotate(topnyDirections[i]);
		}
		for (int i = 1; i <= 4; i++) {
			System.out.println(Arrays.toString(topny[i].topny.toArray()));
		}
		topnyDirections = new int[5];
	}

	private static int totalScore() {
		int sum = 0;
		for (int i = 1; i <= 4; i++) {
			if (topny[i].topny.get(2) == 1) {
				sum += Math.pow(2, i - 1);
			}
		}
		System.out.println(sum);
		return sum;
	}

	private static class Topny {
		List<Integer> topny = new ArrayList<>();

		public Topny(int[] topny) {
			for (int i : topny) {
				this.topny.add(i);
			}
		}

		private void rotate(int direction) {
			if (direction == 1) {
				Integer node = topny.remove(7);
				topny.add(0, node);
			} else if (direction == -1) {
				Integer node = topny.remove(0);
				topny.add(node);
			}
		}
	}
}
