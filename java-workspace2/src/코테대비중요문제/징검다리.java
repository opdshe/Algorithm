package 코테대비중요문제;


import java.util.Arrays;

public class 징검다리 {
	public static void main(String[] args) {
		solution(25, new int[]{2, 14, 11, 17, 21}, 2);
	}

	public static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		return search(distance, rocks, n);
	}

	private static int search(int distance, int[] rocks, int n) {
		int left = 0;
		int right = rocks[rocks.length - 1];
		int pivot = 0;
		int answer = 0;

		while (left <= right) {
			pivot = 0;
			int minDistance = (left + right) / 2;
			int removeRock = 0;
			for (int idx = 0; idx < rocks.length; idx++) {
				if (rocks[idx] - pivot < minDistance) {
					removeRock++;
				} else {
					pivot = rocks[idx];
				}
			}
			if (distance - pivot < minDistance) {
				removeRock++;
			}
			if (removeRock <= n) {
				left = minDistance + 1;
				answer = Math.max(answer, minDistance);
			} else {
				right = minDistance - 1;
			}
		}
		System.out.println(answer);
		return answer;
	}
}