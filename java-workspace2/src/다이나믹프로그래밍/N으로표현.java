package 다이나믹프로그래밍;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class N으로표현 {
	public static void main(String[] args) {
		solution(2, 11);
	}

	public static int solution(int N, int number) {
		Set<Long> set = new HashSet<>();
		Queue<Number> queue = new ArrayDeque<>();
		queue.add(new Number(0, 0));
		int answer = -1;
		while (!queue.isEmpty()) {
			Number current = queue.poll();
			if (current.num == number) {
				answer = current.cost;
				break;
			}
			if (current.cost > 8) {
				break;
			}
			for (int operator = 1; operator <= 5; operator++) {
				long nextNum = getNextNumber(N, current.num, operator);
				if (nextNum >= 0 && !set.contains(nextNum)) {
					set.add(nextNum);
					queue.add(new Number(nextNum, current.cost + 1));
				}
			}
		}
		System.out.println(answer);
		return answer;
	}

	private static boolean isAllN(long number, int N) {
		boolean isAllN = true;
		String convertedNumber = String.valueOf(number);
		for (int idx = 0; idx < convertedNumber.length(); idx++) {
			if (convertedNumber.charAt(idx) != N) {
				isAllN = false;
				break;
			}
		}
		return isAllN;
	}

	private static long getNextNumber(int N, long current, int operator) {
		if (operator == 1) {
			return current + N;
		} else if (operator == 2) {
			return current - N;
		} else if (operator == 3) {
			return current * N;
		} else if (operator == 4) {
			return current / N;
		}
		if (isAllN(current, N)) {
			return Long.parseLong(String.valueOf(current) + N);
		}
		return 0;
	}

	private static class Number {
		long num;
		int cost;

		public Number(long num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}


}
