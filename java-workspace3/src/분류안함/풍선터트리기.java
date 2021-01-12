package 분류안함;

import java.util.HashSet;
import java.util.Set;

public class 풍선터트리기 {
	static Set<Integer> answer = new HashSet();

	public int solution(int[] balloons) {
		int left = balloons[0];
		int right = balloons[balloons.length - 1];
		answer.add(left);
		answer.add(right);
		for (int idx = 1; idx < balloons.length - 1; idx++) {
			if (left > balloons[idx]) {
				answer.add(balloons[idx]);
				left = balloons[idx];
			}
			if (right > balloons[balloons.length - idx]) {
				answer.add(balloons[balloons.length - idx]);
				right = balloons[balloons.length - idx];
			}
		}
		return answer.size();
	}
}
