package 라인2020;

import java.util.HashMap;
import java.util.Map;

public class 사번 {
	static Map<Integer, Integer> candy = new HashMap<>();

	public static void main(String[] args) {
		solution(new int[][]{{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}});
	}

	public static int solution(int[][] boxes) {
		int time = 1;
		for (int[] box : boxes) {
			if (box[0] == box[1]) {
				continue;
			}
			if (!candy.containsKey(box[0])) {
				candy.put(box[0], 1);
			} else {
				candy.remove(box[0]);
			}
			if (!candy.containsKey(box[1])) {
				candy.put(box[1], 1);
			} else {
				candy.remove(box[1]);
			}
			System.out.println("time =" + time);
			for (Map.Entry<Integer, Integer> integerIntegerEntry : candy.entrySet()) {
				System.out.println(integerIntegerEntry.getKey() + "  " + integerIntegerEntry.getValue());
			}
			System.out.println("============");
			time++;
		}
		System.out.println(candy.size());
		return 0;
	}
}