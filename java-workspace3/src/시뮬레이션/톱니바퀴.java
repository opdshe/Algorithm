package 시뮬레이션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 톱니바퀴 {
	static Scanner scanner = new Scanner(System.in);
	static List<Tire> tires = new ArrayList<>();

	public static void main(String[] args) {
		tires.add(new Tire());
		for (int i = 0; i < 4; i++) {
			tires.add(new Tire(scanner.nextLine()));
		}
		int countOfRotate = scanner.nextInt();
		for (int i = 0; i < countOfRotate; i++) {
			int target = scanner.nextInt();
			int direction = scanner.nextInt();
			rotate(target, direction);
		}
		int score = getScore();
		System.out.println(score);
	}

	private static int getScore() {
		int score = 0;
		if (tires.get(1).directions.get(0) == 1) {
			score += 1;
		}
		if (tires.get(2).directions.get(0) == 1) {
			score += 2;
		}
		if (tires.get(3).directions.get(0) == 1) {
			score += 4;
		}
		if (tires.get(4).directions.get(0) == 1) {
			score += 8;
		}
		return score;
	}

	private static void rotate(int target, int direction) {
		//1은 시계, -1 반시계
		int[] rotateDirection = new int[5];
		rotateDirection[target] = direction;
		//target보다 왼쪽
		for (int idx = target - 1; idx >= 1; idx--) {
			Tire current = tires.get(idx);
			Tire right = tires.get(idx + 1);
			if (!current.directions.get(2).equals(right.directions.get(6))) {
				rotateDirection[idx] = -rotateDirection[idx + 1];
			} else {
				break;
			}
		}
		//target보다 오른쪽
		for (int idx = target + 1; idx <= 4; idx++) {
			Tire current = tires.get(idx);
			Tire left = tires.get(idx - 1);
			if (!current.directions.get(6).equals(left.directions.get(2))) {
				rotateDirection[idx] = -rotateDirection[idx - 1];
			} else {
				break;
			}
		}
		for (int idx = 1; idx <= 4; idx++) {
			Tire tire = tires.get(idx);
			tire.rotate(rotateDirection[idx]);
		}
	}

	private static class Tire {
		List<Integer> directions;

		public Tire(String direction) {
			this.directions = Arrays.stream(direction.split(""))
					.mapToInt(Integer::parseInt)
					.boxed()
					.collect(Collectors.toList());
		}

		public Tire() {
		}

		public void rotate(int direction) {
			if (direction == 1) {
				Integer node = directions.remove(directions.size() - 1);
				directions.add(0, node);
			} else if (direction == -1) {
				Integer node = directions.remove(0);
				directions.add(node);
			}
		}
	}
}
