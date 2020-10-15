package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구간합구하기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] numbers = new int[input[0]];
		for (int idx = 0; idx < input[0]; idx++) {
			numbers[idx] = Integer.parseInt(bufferedReader.readLine());
		}

		SegmentTree segmentTree = new SegmentTree(numbers, input[0]);
		for (int idx = 0; idx < input[1] + input[2]; idx++) {
			int[] order = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			operate(segmentTree, order, numbers);
		}
	}

	private static void operate(SegmentTree segmentTree, int[] order, int[] numbers) {
		//변경하기
		if (order[0] == 1) {
			int newValue = order[2];
			int diff = newValue - numbers[order[1] - 1];
			numbers[order[1] - 1] = newValue;
			segmentTree.update(order[1] - 1, diff, 0, numbers.length - 1, 1);
		}
		//합 구하기
		else if (order[0] == 2) {
			long sum = segmentTree.getSum(order[1] - 1, order[2] - 1, 0, numbers.length - 1, 1);
			System.out.println(sum);
		}
	}

	private static class SegmentTree {
		private long[] seg;

		private SegmentTree(int[] arr, int arrSize) {
			int height = arrSize * 4;
			seg = new long[height];
			init(arr, 0, arrSize - 1, 1);
		}

		private long init(int[] arr, int left, int right, int node) {
			//리프노드
			if (left == right) {
				return seg[node] = arr[left];
			}
			int mid = (left + right) / 2;
			return seg[node] = init(arr, left, mid, node * 2) + init(arr, mid + 1, right, node * 2 + 1);
		}

		private long getSum(int begin, int end, int left, int right, int node) {
			if (right < begin || left > end) {
				return 0;
			} else if ((begin <= left && right <= end)) {
				return seg[node];
			} else {
				int mid = (left + right) / 2;
				return getSum(begin, end, left, mid, node * 2) + getSum(begin, end, mid + 1, right, node * 2 + 1);
			}
		}

		private void update(int target, int diff, int left, int right, int node) {
			if (!(left <= target && target <= right)) {
				return;
			}
			seg[node] += diff;
			if (left != right) {
				int mid = (left + right) / 2;
				update(target, diff, left, mid, node * 2);
				update(target, diff, mid + 1, right, node * 2 + 1);
			}
		}
	}
}
