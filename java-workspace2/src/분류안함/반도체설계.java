package 분류안함;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 반도체설계 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfLine = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int idx = 0; idx < countOfLine; idx++) {
			int line = scanner.nextInt();
			if (list.isEmpty()) {
				list.add(line);
			} else {
				if (list.get(list.size() - 1) < line) {
					list.add(line);
				} else {
					int position = Collections.binarySearch(list, line);
					if (position < 0) {
						position = -position - 1;
					}
					list.set(position, line);
				}
			}
		}
		System.out.println(list.size());
	}
}
