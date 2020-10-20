package 이분탐색;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 개똥벌레 {
	static Scanner scanner = new Scanner(System.in);
	static int maxHeight;
	static int countOfRock;

	public static void main(String[] args) {
		countOfRock = scanner.nextInt();
		maxHeight = scanner.nextInt();
		List<Integer> upper = new ArrayList<>();
		List<Integer> lower = new ArrayList<>();
		for (int idx = 1; idx <= countOfRock; idx++) {
			if (idx % 2 == 1) {
				lower.add(scanner.nextInt());
			} else {
				upper.add(scanner.nextInt());
			}
		}
		solution(lower, upper, countOfRock);
	}

	private static void solution(List<Integer> lower, List<Integer> upper, int countOfRock) {
		lower.sort(Comparator.naturalOrder());
		upper.sort(Comparator.naturalOrder());
		int minBrokenRock = countOfRock;
		int count = 0;
		for (int height = 1; height <= maxHeight; height++) {
			int lowerIdx = binarySearch(lower, height);
			int upperIdx = binarySearch(upper, maxHeight - height + 1);

			int lowerCount = lower.size() - lowerIdx;
			int upperCount = upper.size() - upperIdx;
			int total = lowerCount + upperCount;
			if (minBrokenRock > total) {
				minBrokenRock = total;
				count = 1;
			} else if (minBrokenRock == total) {
				count++;
			}
		}
		System.out.println(minBrokenRock + " " + count);
	}

	private static int binarySearch(List<Integer> list, int target) {
		int left = 0;
		int right = list.size() - 1; // index
		// l가 r랑 같아질때 까지
		while (left <= right) {
			int mid = (left + right) / 2;
			if (list.get(mid) < target) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return left;
	}
}
