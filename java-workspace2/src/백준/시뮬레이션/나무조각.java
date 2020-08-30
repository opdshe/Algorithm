package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 나무조각 {
	static List<Integer> parts = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			parts.add(scanner.nextInt());
		}
		while (true) {
			for (int i = 0; i < 4; i++) {
				if (swap(i)) {
					printWoods();
				}
			}
			if (check()) {
				break;
			}
		}
	}

	private static boolean check() {
		for (int i = 0; i < 5; i++) {
			if (parts.get(i) != i + 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean swap(int idx) {
		if (parts.get(idx) > parts.get(idx + 1)) {
			Integer target = parts.remove(idx);
			parts.add(idx + 1, target);
			return true;
		}
		return false;
	}

	private static void printWoods() {
		for (int i = 0; i < 5; i++) {
			System.out.print(parts.get(i) + " ");
		}
		System.out.println();
	}
}
