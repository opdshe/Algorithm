package 이분탐색;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 두배열의합 {
	static Scanner scanner = new Scanner(System.in);
	static List<Long> subA = new ArrayList<>();
	static List<Long> subB = new ArrayList<>();

	public static void main(String[] args) {
		long target = scanner.nextInt();
		int countOfA = scanner.nextInt();
		int[] A = new int[countOfA];
		for (int idx = 0; idx < countOfA; idx++) {
			A[idx] = scanner.nextInt();
		}
		int countOfB = scanner.nextInt();
		int[] B = new int[countOfB];
		for (int idx = 0; idx < countOfB; idx++) {
			B[idx] = scanner.nextInt();
		}
		initSubArray(subA, A, countOfA);
		initSubArray(subB, B, countOfB);
		int count = 0;
		for (int idx = 0; idx < subA.size(); idx++) {
			long T = target - subA.get(idx);
			count += upper_bound(subB, T) - lower_bound(subB, T);
		}
		System.out.println(count);
	}

	private static void initSubArray(List<Long> list, int[] array, int countOfTarget) {
		for (int start = 0; start < countOfTarget; start++) {
			long sum = 0;
			for (int end = start; end < countOfTarget; end++) {
				sum += array[end];
				list.add(sum);
			}
		}
		list.sort(Comparator.naturalOrder());
	}

	//target이 들어갈 idx 찾기 (가장 앞의 인덱스)
	private static int lower_bound(List<Long> list, long target) {
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

	//target이 들어갈 idx 찾기 (가장 마지막 인덱스)
	private static int upper_bound(List<Long> list, long target) {
		int left = 0;
		int right = list.size() - 1; // index
		// l가 r랑 같아질때 까지
		while (left <= right) {
			int mid = (left + right) / 2;
			if (list.get(mid) <= target) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return left;
	}
}
