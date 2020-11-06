package 구현;

import java.util.Scanner;

public class ACM호텔 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int row = scanner.nextInt();
			int column = scanner.nextInt();
			int idx = scanner.nextInt();
			int floor = (idx % row);
			if (floor == 0) {
				int distance = idx / row;
				System.out.println(row + String.format("%02d", distance));
			} else {
				int distance = (idx / row) + 1;
				System.out.println(floor + String.format("%02d", distance));
			}
		}
	}
}
