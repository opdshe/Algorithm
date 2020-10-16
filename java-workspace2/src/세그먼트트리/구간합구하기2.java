package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구간합구하기2 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] number = new int[input[0]];
		for (int idx = 0; idx < input[0]; idx++) {
			number[idx] = Integer.parseInt(bufferedReader.readLine());
		}
		SegmentTree segmentTree = new SegmentTree(number, input[0]);
		for (int idx = 0; idx < input[1] + input[2]; idx++) {
			int[] order = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			operate(segmentTree, order, number);
		}
	}

	private static void operate(SegmentTree segmentTree, int[] order, int[] number) {
		//b부터 c까지 d 더하기
		if (order[0] == 1) {
			for (int idx = order[1] - 1; idx < order[2]; idx++) {
				number[idx] += order[3];
				segmentTree.update(idx, order[3], 0, number.length - 1, 1);
			}
		} else if (order[0] == 2) {
			long sum = segmentTree.getSum(order[1] - 1, order[2] - 1, 0, number.length - 1, 1);
			System.out.println(sum);
		}
	}

	private static class SegmentTree {
		private long[] segments;

		private SegmentTree(int[] array, int arraySize) {
			int height = arraySize * 4;
			segments = new long[height];
			init(array, 0, arraySize - 1, 1);
		}

		private long init(int[] array, int left, int right, int node) {
			if (left == right) {
				return segments[node] = array[left];
			}
			int mid = (left + right) / 2;
			return segments[mid] = init(array, left, mid, node * 2) + init(array, mid + 1, right, node * 2 + 1);
		}

		private long getSum(int begin, int end, int left, int right, int node) {
			if (begin > right || end < left) {
				return 0;
			} else if (begin <= left && right <= end) {
				return segments[node];
			} else {
				int mid = (left + right) / 2;
				return getSum(begin, end, left, mid, node * 2) + getSum(begin, end, mid + 1, right, node * 2 + 1);
			}
		}

		private void update(int target, int diff, int left, int right, int node) {
			if (!(left <= target && target <= right)) {
				return;
			}
			segments[node] += diff;
			if (left != right) {
				int mid = (left + right) / 2;
				update(target, diff, left, mid, node * 2);
				update(target, diff, mid + 1, right, node * 2 + 1);
			}

		}
	}
}
