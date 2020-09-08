package 백준.재귀;

import java.util.Scanner;

public class 종이의개수 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] paper;
	static int[] answer = new int[3];

	public static void main(String[] args) {
		size = scanner.nextInt();
		paper = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				paper[i][j] = scanner.nextInt();
			}
		}
		recur(0, 0, size);
		for (int i = 0; i < 3; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void recur(int height, int width, int size) {
		int target = paper[height][width];
		boolean isAllSameNumber = true;
		for (int h = height; h < height + size; h++) {
			for (int w = width; w < width + size; w++) {
				if (paper[h][w] != target) {
					isAllSameNumber = false;
					break;
				}
			}
		}
		if (!isAllSameNumber) {
			for (int h = height; h < height + size; h += size / 3) {
				for (int w = width; w < width + size; w += size / 3) {
					recur(h, w, size / 3);
				}
			}
		} else {
			if (target == -1) {
				answer[0]++;
			} else if (target == 0) {
				answer[1]++;
			} else if (target == 1) {
				answer[2]++;
			}
		}
	}
}
