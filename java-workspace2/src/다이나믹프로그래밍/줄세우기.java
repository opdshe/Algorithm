package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 줄세우기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int idx = 0; idx < countOfPeople; idx++) {
			int order = scanner.nextInt();
			if (list.isEmpty()) {
				list.add(order);
				continue;
			}
			if (list.get(list.size() - 1) < order) {
				list.add(order);
			} else {
				int position = Collections.binarySearch(list, order);
				if (position < 0) {
					position = -position - 1;
				}
				list.set(position, order);
			}
		}
		System.out.println(countOfPeople - list.size());
	}
}
