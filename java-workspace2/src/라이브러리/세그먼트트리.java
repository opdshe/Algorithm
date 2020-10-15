package 라이브러리;


import java.util.Arrays;

public class 세그먼트트리 {
	public static void main(String[] args) {
		int[] arr = {5, 3, 7, 9, 6, 4, 1, 2, 1};
		SegmentTree segmentTree = new SegmentTree(arr, arr.length);
		System.out.println(Arrays.toString(segmentTree.seg));
		System.out.println(segmentTree.getSum(0, 3, 0, arr.length - 1, 1));
		segmentTree.update(2, 2, 0, arr.length - 1, 1);
		System.out.println(Arrays.toString(segmentTree.seg));
	}

	private static class SegmentTree {
		int height;
		long[] seg;

		private SegmentTree(int[] arr, int arraySize) {
			height = arraySize * 4;
			seg = new long[height];
			init(arr, 0, arraySize - 1, 1);
		}

		private long init(int[] arr, int left, int right, int node) {
			//리프노드
			if (left == right) {
				return seg[node] = arr[left];
			}
			int mid = (left + right) / 2;
			return seg[node] = init(arr, left, mid, node * 2) + init(arr, mid + 1, right, node * 2 + 1);
		}

		//begin, end 는 검색하고자 하는 타겟 인덱스
		private long getSum(int begin, int end, int left, int right, int node) {
			if (end < left || right < begin) {
				return 0;
			} else if (begin <= left && right <= end) {
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

