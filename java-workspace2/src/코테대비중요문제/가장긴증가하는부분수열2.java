package 코테대비중요문제;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class 가장긴증가하는부분수열2 {
	static Scanner scanner = new Scanner(System.in);
	static Vector<Integer> list = new Vector<>();
	static int n;

	public static void main(String[] args) {
		n = scanner.nextInt();
		for (int idx = 0; idx < n; idx++) {
			int value = scanner.nextInt();
			if (list.isEmpty()) {
				list.add(value);
				continue;
			}
			if (list.get(list.size() - 1) < value) {
				list.add(value);
			} else {
				int position = Collections.binarySearch(list, value);
				if (position >= 0) {
					list.set(position, value);
				} else {
					list.set(-position - 1, value);
				}
			}
		}
		System.out.println(list.size());
	}
}
