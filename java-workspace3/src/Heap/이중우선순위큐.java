package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이중우선순위큐 {
	public int[] solution(String[] operations) {
		List<Integer> list = new ArrayList<>();
		for (String operation : operations) {
			String[] split = operation.split(" ");
			if (split[0].equals("I")) {
				add(list, Integer.parseInt(split[1]));
			} else {
				if (list.size() == 0) {
					continue;
				}
				if (Integer.parseInt(split[1]) >= 0) {
					list.remove(list.size() - 1);
				} else {
					list.remove(0);
				}
			}
		}
		if (list.size() == 0) {
			return new int[]{0, 0};
		}
		return new int[]{list.get(list.size() - 1), list.get(0)};
	}

	private static void add(List<Integer> list, int target) {
		int idx = Collections.binarySearch(list, target);
		if (idx >= 0) {
			list.add(idx, target);
		} else {
			list.add(-(idx + 1), target);
		}
	}
}
