package 그리디;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	public int solution(int[][] routes) {
		Arrays.sort(routes, Comparator.comparing((int[] a) -> a[1]));
		int answer = 0;
		int endPoint = Integer.MIN_VALUE;
		for (int idx = 0; idx < routes.length; idx++) {
			int[] route = routes[idx];
			if (route[0] > endPoint) {
				answer++;
				endPoint = route[1];
			}
		}
		return answer;
	}
}
