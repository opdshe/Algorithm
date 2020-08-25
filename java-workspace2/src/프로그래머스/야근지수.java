package 프로그래머스;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 야근지수 {
	public static void main(String[] args) {
		solution(4, new int[]{4, 3, 3});
	}

	public static long solution(int n, int[] works) {
		Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int work : works) {
			queue.add(work);
		}
		while (n > 0) {
			if (queue.isEmpty()) {
				break;
			}
			int value = queue.poll() - 1;
			if (value > 0) {
				queue.add(value);
			}
			n--;
		}
		long sum = 0;
		while (!queue.isEmpty()) {
			sum += Math.pow(queue.poll(), 2);
		}
		System.out.println(sum);
		return sum;
	}
}
