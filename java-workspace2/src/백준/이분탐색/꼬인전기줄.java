package 백준.이분탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 꼬인전기줄 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int[] cache;
	static List<Integer> lines = new ArrayList<>();

	public static void main(String[] args) {
		N = scanner.nextInt();
		for (int i = 1; i <= N; i++) {
			add(scanner.nextInt());
		}
		System.out.println(N - lines.size());
	}

	private static void add(int value) {
		if (lines.size() == 0) {
			lines.add(value);
		} else {
			if (value >= lines.get(lines.size() - 1)) {
				lines.add(value);
			} else {
				int idx = Collections.binarySearch(lines, value);
				if (idx > 0) {
					lines.set(idx, value);
				} else {
					lines.set(-idx - 1, value);
				}
			}
		}
	}

	private static void search() {

	}
}
