package 기출.카카오인턴;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 삼번 {
	private static Map<Integer, Boolean> map = new HashMap<>();
	private static Stack<Integer> stack = new Stack<>();
	private static int max;
	private static int lastIdx;
	private static int currentIdx;

	public static void main(String[] args) {
		solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"});
	}

	public static String solution(int n, int k, String[] cmd) {
		init(n, k);
		StringBuilder answer = new StringBuilder();
		for (String order : cmd) {
			operate(order);
		}
		answer.append("O".repeat(Math.max(0, n)));
		while (!stack.isEmpty()) {
			Integer idx = stack.pop();
			answer.setCharAt(idx, 'X');
		}
		return answer.toString();
	}

	private static int findUpperIdx(int current, int target) {
		int count = 0;
		int next = -1;
		for (int idx = current - 1; idx >= 0; idx--) {
			if (map.get(idx)) {
				count++;
			}
			if (count == target) {
				next = idx;
				break;
			}
		}
		return next;
	}

	private static int findLowerIdx(int current, int target) {
		int count = 0;
		int next = -1;
		for (int idx = current + 1; current < lastIdx; idx++) {
			if (map.get(idx)) {
				count++;
			}
			if (count == target) {
				next = idx;
				break;
			}
		}
		return next;
	}

	private static void operate(String order) {
		String[] split = order.split(" ");
		if (split[0].equals("U")) {
			currentIdx = findUpperIdx(currentIdx, Integer.parseInt(split[1]));
		} else if (split[0].equals("D")) {
			currentIdx = findLowerIdx(currentIdx, Integer.parseInt(split[1]));
		} else if (split[0].equals("C")) {
			stack.push(currentIdx);
			map.put(currentIdx, false);
			if (currentIdx == lastIdx) {
				currentIdx = findUpperIdx(currentIdx, 1);
				lastIdx = currentIdx;
			} else {
				currentIdx = findLowerIdx(currentIdx, 1);
			}
		} else {
			Integer last = stack.pop();
			map.put(last, true);
		}
	}

	private static void init(int n, int k) {
		max = n - 1;
		currentIdx = k;
		lastIdx = n - 1;
		for (int idx = 0; idx < n; idx++) {
			map.put(idx, true);
		}
	}
}
