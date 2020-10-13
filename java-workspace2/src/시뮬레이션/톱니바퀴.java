package 시뮬레이션;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 톱니바퀴 {
	static Scanner scanner = new Scanner(System.in);
	static Tire[] tires = new Tire[5];

	public static void main(String[] args) throws IOException {
		for (int idx = 1; idx <= 4; idx++) {
			tires[idx] = new Tire(Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::parseInt)
					.boxed()
					.collect(Collectors.toList()), 0);
		}
		int countOfRotate = scanner.nextInt();
		for (int idx = 0; idx < countOfRotate; idx++) {
			int target = scanner.nextInt();
			int dir = scanner.nextInt();
			setDirection(target, dir);
			for (int i = 1; i <= 4; i++) {
				tires[i].rotate();
			}
		}
		calculate();
	}

	private static void calculate() {
		int sum = 0;
		for (int idx = 1; idx <= 4; idx++) {
			if (tires[idx].elements.get(0) == 1) {
				sum += (int) Math.pow(2, idx - 1);
			}
		}
		System.out.println(sum);
	}

	private static void setDirection(int target, int dir) {
		for (int idx = 1; idx <= 4; idx++) {
			tires[idx].dir = 0;
		}
		tires[target].dir = dir;

		int currentLeft = tires[target].elements.get(6);
		int leftDir = -dir;
		for (int idx = target - 1; idx >= 1; idx--) {
			if (currentLeft != tires[idx].elements.get(2)) {
				currentLeft = tires[idx].elements.get(6);
				tires[idx].dir = leftDir;
				leftDir = -leftDir;
			} else {
				break;
			}
		}

		int currentRight = tires[target].elements.get(2);
		int rightDir = -dir;
		for (int idx = target + 1; idx <= 4; idx++) {
			if (currentRight != tires[idx].elements.get(6)) {
				currentRight = tires[idx].elements.get(2);
				tires[idx].dir = rightDir;
				rightDir = -rightDir;
			} else {
				break;
			}
		}
	}

	private static class Tire {
		private List<Integer> elements;
		private int dir;

		public Tire(List<Integer> elements, int dir) {
			this.elements = elements;
			this.dir = dir;
		}

		private void rotate() {
			if (dir == 1) {
				Integer el = this.elements.remove(7);
				this.elements.add(0, el);
			} else if (dir == -1) {
				Integer el = this.elements.remove(0);
				this.elements.add(el);
			}
		}
	}
}
