package 구현;

import java.util.ArrayDeque;
import java.util.Queue;

public class 캐시2 {
	public static int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return 5 * cities.length;
		}
		int answer = 0;
		Queue<String> queue = new ArrayDeque<>();
		for (String city : cities) {
			String upperCity = city.toUpperCase();
			if (queue.contains(upperCity)) {
				answer += 1;
				queue.remove(upperCity);
			} else {
				if (queue.size() >= cacheSize) {
					queue.poll();
				}
				answer += 5;
			}
			queue.add(upperCity);
		}
		System.out.println(answer);
		return answer;
	}
}
