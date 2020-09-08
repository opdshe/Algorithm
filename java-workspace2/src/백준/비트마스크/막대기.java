package 백준.비트마스크;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 막대기 {
	static Scanner scanner = new Scanner(System.in);
	static int target;
	static float current = 64f;

	public static void main(String[] args) {
		target = scanner.nextInt();
		search();
	}

	private static void search() {
		Queue<Float> queue = new PriorityQueue<>();
		queue.add(64f);

		while (true) {
			if (current > target) {
				Float part = queue.poll();
				current -= part;
				Float mid = part / 2;
				if (current + mid >= target) {
					current += mid;
					queue.add(mid);
				} else {
					current += part;
					queue.add(mid);
					queue.add(mid);
				}
			} else if (current == target) {
				break;
			}
		}
		System.out.println(queue.size());
	}
}
