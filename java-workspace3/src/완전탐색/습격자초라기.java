package 완전탐색;

import java.util.Scanner;

public class 습격자초라기 {
	static Scanner scanner = new Scanner(System.in);
	static int answer;

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			answer = Integer.MAX_VALUE;
			int unit = scanner.nextInt();
			int W = scanner.nextInt();
			int[] people = new int[unit * 2];
			boolean[] visited = new boolean[unit * 2];
			for (int i = 0; i < unit * 2; i++) {
				people[i] = scanner.nextInt();
			}
			search(people, visited, unit, W, 0, 1);
			System.out.println(answer);
		}
	}

	private static void search(int[] people, boolean[] visited, int unit, int W, int idx, int count) {
		if (idx == unit * 2 - 1) {
			answer = Math.min(answer, count);
			return;
		}
		if (visited[idx]) {
			search(people, visited, unit, W, idx + 1, count);
		} else {
			System.out.println("current : " + idx);
			visited[idx] = true;
			//위
			int upper = idx + unit;
			if (isAvailable(visited, unit, upper) && people[idx] + people[upper] <= W) {
				System.out.println("upper");
				visited[upper] = true;
				search(people, visited, unit, W, idx + 1, count + 1);
				visited[upper] = false;
			}
			int left = (idx + unit - 1) % unit;
			if (isAvailable(visited, unit, left) && people[idx] + people[left] <= W) {
				System.out.println("left");
				visited[left] = true;
				search(people, visited, unit, W, idx + 1, count + 1);
				visited[left] = false;
			}
			int right = (idx + 1) % unit;
			if (isAvailable(visited, unit, right) && people[idx] + people[right] <= W) {
				System.out.println("right");
				visited[right] = true;
				search(people, visited, unit, W, idx + 1, count + 1);
				visited[right] = false;
			}
			search(people, visited, unit, W, idx + 1, count + 1);
		}

	}

	private static boolean isAvailable(boolean[] visited, int unit, int position) {
		return position >= 0 && position < unit * 2 && !visited[position];
	}
}
