package 구현;

import java.util.ArrayDeque;
import java.util.Queue;

public class 캐시2 {
	private static final int CACHE_HIT = 1;
	private static final int CACHE_MISS = 5;

	public static int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return CACHE_MISS * cities.length;
		}

		int answer = 0;
		Queue<String> queue = new ArrayDeque<>();
		for (String city : cities) {
			city = city.toLowerCase();
			if (queue.contains(city)) {
				queue.remove(city);
				queue.add(city);
				answer += CACHE_HIT;
				continue;
			}
			//없는 경우
			if (queue.size() >= cacheSize) {
				queue.poll();
			}
			queue.add(city);
			answer += CACHE_MISS;
		}
		return answer;
	}
}
