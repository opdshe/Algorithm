package 카카오.카카오상반기2020;

import java.util.Arrays;
import java.util.Scanner;

public class 자물쇠와열쇠 {
	static Scanner scanner = new Scanner(System.in);
	static int keySize;
	static int lockSize;
	static int[][] map;

	public static void main(String[] args) {
		solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
				new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
	}

	public static boolean solution(int[][] key, int[][] lock) {
		keySize = key.length;
		lockSize = lock.length;
		map = new int[2 * (keySize - 1) + lockSize][2 * (keySize - 1) + lockSize];
		initLock(lock);
		for (int i = 0; i < lock.length; i++) {
			System.out.println(Arrays.toString(lock[i]));
		}
		int[][] rotatedLock = rotate(lock);
		for (int i = 0; i < lock.length; i++) {
			System.out.println(Arrays.toString(rotatedLock[i]));
		}
		return true;
	}

	private static void initLock(int[][] lock) {
		int startHeight = keySize - 1;
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				map[i + startHeight][j + startHeight] = lock[i][j];
			}
		}
	}

	private static int[][] rotate(int[][] target) {
		int[][] rotatedTarget = new int[target.length][target.length];
		for (int i = 0; i < target.length; i++) {
			for (int j = 0; j < target.length; j++) {
				rotatedTarget[j][target.length - 1 - i] = target[i][j];
			}
		}
		return rotatedTarget;
	}

	private static boolean isAvailableToUnlock(int startHeight, int startWidth, int[][] key) {
		for (int h = startHeight; h < keySize; h++) {
			for (int w = startWidth; w < keySize; w++) {
				map[h][w] = key[h - startHeight][w - startWidth];
			}
		}
		return true;
	}
}
