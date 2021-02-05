package LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < countOfNumber; i++) {
			int value = scanner.nextInt();
			if (list.isEmpty()) {
				list.add(value);
			} else {
				if (list.get(list.size() - 1) < value) {
					list.add(value);
				} else {
					int position = getPosition(list, value);
					list.set(position, value);
				}
			}
		}
		System.out.println(list.size());
	}

	private static int getPosition(List<Integer> list, int target) {
		int position = Collections.binarySearch(list, target);
		if (position < 0) {
			position = -(position) - 1;
		}
		return position;
	}

}
