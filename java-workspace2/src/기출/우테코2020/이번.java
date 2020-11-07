package 기출.우테코2020;

import java.util.ArrayList;
import java.util.List;

public class 이번 {
	public static void main(String[] args) {
		solution("1234", "+");
	}

	public static long[] solution(String s, String op) {
		List<Long> answers = new ArrayList<>();
		for (int splitPoint = 1; splitPoint < s.length(); splitPoint++) {
			long head = Long.parseLong(s.substring(0, splitPoint));
			long tail = Long.parseLong(s.substring(splitPoint));
			answers.add(calculate(head, tail, op));
		}
		return answers.stream()
				.mapToLong(Long::valueOf)
				.toArray();
	}

	public static long calculate(long head, long tail, String op) {
		if (op.equals("+")) {
			return head + tail;
		} else if (op.equals("-")) {
			return head - tail;
		} else {
			return head * tail;
		}
	}
}
