package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 원판돌리기 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int M;
	static int T;

	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		T = scanner.nextInt();
		Roulette roulette = new Roulette();
		for (int i = 0; i < N; i++) {
			roulette.add(Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray());
		}
	}

	private static class Roulette {
		private List<Circle> circles = new ArrayList<>();

		private void add(int[] inputs) {
			circles.add(new Circle(inputs));
		}

		private void rotate(int idx, int direction, int value) {
			circles.get(idx - 1).rotate(direction, value);

		}
	}

	private static class Circle {
		private List<Integer> numbers = new ArrayList<>();

		public Circle(int[] input) {
			numbers.addAll(Arrays.stream(input)
					.boxed()
					.collect(Collectors.toList()));
		}

		private void rotate(int direction, int value) {
			if (direction == 1) {
				value = 4 - value;
			}
			while (value > 0) {
				numbers.add(0, numbers.remove(numbers.size() - 1));
				value--;
			}
		}
	}
}
