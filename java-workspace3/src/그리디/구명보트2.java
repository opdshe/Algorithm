package 그리디;

import java.util.Arrays;

public class 구명보트2 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int left = 0;
		int right = people.length - 1;
		while (left <= right) {
			int sum = people[left] + people[right];
			if (sum <= limit) {
				left++;
				right--;
			} else {
				right--;
			}
			answer++;
		}
		return answer;
	}
}
