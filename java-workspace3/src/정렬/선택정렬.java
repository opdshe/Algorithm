package 정렬;

import java.util.Arrays;

public class 선택정렬 {
	public static void main(String[] args) {
		int[] array = new int[]{2, 5, 3, 1, 7};
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void selectionSort(int[] array) {
		for (int pivotIdx = 0; pivotIdx < array.length - 1; pivotIdx++) {
			int minIdx = pivotIdx;
			for (int compareIdx = pivotIdx + 1; compareIdx < array.length; compareIdx++) {
				if (array[minIdx] > array[compareIdx]) {
					minIdx = compareIdx;
				}
			}
			int copy = array[pivotIdx];
			array[pivotIdx] = array[minIdx];
			array[minIdx] = copy;
		}
	}
}
