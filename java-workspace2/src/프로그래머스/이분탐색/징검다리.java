package 프로그래머스.이분탐색;


import java.util.Arrays;

public class 징검다리 {
	static int answer = 0;

	public static void main(String[] args) {
		//2 11 14 17 21
		solution(25, new int[]{2, 14, 11, 17, 21}, 2);
	}

	public static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		search(distance, rocks, n);
		System.out.println(answer);
		return answer;
	}

	private static int search(int distance, int[] rocks, int n) {
		int left = 0;
		int right = distance;
		answer = 0;
		while (left <= right) {
			int pivot = 0;
			int minDistance = (left + right) / 2;
			int count = 0;
			for (int i = 0; i < rocks.length; i++) {
				if ((rocks[i] - pivot) < minDistance) {
					count++;
				} else {
					pivot = rocks[i];
				}
			}
			if ((distance - pivot) < minDistance) {
				count++;
			}
			if (count <= n) {
				answer = Math.max(answer, minDistance);
				left = minDistance + 1;
			} else {
				right = minDistance - 1;
			}
		}
		return answer;
	}
}