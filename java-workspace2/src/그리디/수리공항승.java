package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class 수리공항승 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfHole = scanner.nextInt();
		int lengthOfTape = scanner.nextInt();
		int[] holePositions = new int[countOfHole];
		for (int idx = 0; idx < countOfHole; idx++) {
			holePositions[idx] = scanner.nextInt();
		}
		Arrays.sort(holePositions);
		solution(holePositions, countOfHole, lengthOfTape);
	}

	private static void solution(int[] holePositions, int countOfHole, int lengthOfTape) {
		int currentPosition = holePositions[0];
		int count = 1;
		for (int idx = 1; idx < countOfHole; idx++) {
			int hole = holePositions[idx];
			if (hole - currentPosition >= lengthOfTape) {
				count++;
				currentPosition = hole;
			}
		}
		System.out.println(count);
	}
}