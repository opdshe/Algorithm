package 정렬;

import java.util.Arrays;

public class 버블소트 {
	public static void main(String[] args) {
		int[] array = new int[]{1, 5, 4, 2, 3, 7};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void bubbleSort(int[] array) {
		for (int trial = 0; trial < array.length; trial++) {
			for (int idx = 0; idx < array.length - 1 - trial; idx++) {
				if (array[idx] > array[idx + 1]) {
					int copy = array[idx];
					array[idx] = array[idx + 1];
					array[idx + 1] = copy;
				}
			}
		}
	}
}
