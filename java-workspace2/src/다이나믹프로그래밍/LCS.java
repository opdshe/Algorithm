package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class LCS {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String first = scanner.nextLine();
		String second = scanner.nextLine();
		int[] lastIdx = new int[first.length()];
		setLastIdx(first, second, lastIdx);

		int[] result = new int[first.length()];
		setResult(lastIdx, result);
		System.out.println(Arrays.stream(result)
				.max()
				.getAsInt());
	}

	private static void setLastIdx(String first, String second, int[] lastIdx) {
		Arrays.fill(lastIdx, -1);
		for (int pivot = 0; pivot < lastIdx.length; pivot++) {
			for (int target = 0; target < pivot; target++) {
				if (first.charAt(target) == second.charAt(pivot)) {
					lastIdx[pivot] = target;
				}
			}
		}
	}

	private static void setResult(int[] lastIdx, int[] result) {
		for (int pivot = 1; pivot < lastIdx.length; pivot++) {
			for (int target = 0; target < pivot; target++) {
				if (lastIdx[pivot] > lastIdx[target] && result[pivot] <= result[target]) {
					result[pivot] = result[target] + 1;
				}
			}
		}
	}
}
