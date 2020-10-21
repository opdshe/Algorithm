package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int idx = 0; idx < size; idx++) {
			int value = scanner.nextInt();
			if (list.isEmpty()) {
				list.add(value);
			}
			if (list.get(list.size() - 1) < value) {
				list.add(value);
			} else {
				int position = Collections.binarySearch(list, value);
				if (position < 0) {
					position = -position - 1;
				}
				list.set(position, value);
			}
		}
		System.out.println(list.size());
	}
}
