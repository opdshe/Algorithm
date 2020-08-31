package 카카오2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 무지의먹방라이브 {
	static int answer = -1;
	static List<Food> foods = new ArrayList<>();
	static List<Food> candidates = new ArrayList<>();

	public static void main(String[] args) {
		solution(new int[]{3, 1, 1, 1, 2, 4, 3}, 12);
	}

	public static int solution(int[] food_times, long k) {
		for (int i = 0; i < food_times.length; i++) {
			int remains = food_times[i];
			foods.add(new Food(i, remains));
		}
		foods.sort(Comparator.comparing((Food f) -> f.remains));

		int countOfFood = food_times.length;
		int removeSize = 0;
		for (int i = 0; i < countOfFood; i++) {
			long height = foods.get(i).remains - removeSize;
			long remainingFoods = countOfFood - i;
			long total = height * remainingFoods;
			if (total <= k) {
				k -= total;
				removeSize += height;
			} else {
				k %= remainingFoods;
				candidates = foods.subList(i, foods.size());
				candidates.sort(Comparator.comparing((Food f) -> f.idx));
				break;
			}
		}
		if (candidates.size() == 0) {
			return -1;
		}
		answer = candidates.get((int) k).idx + 1;
		return answer;
	}

	private static class Food {
		private int idx;
		private int remains;

		public Food(int idx, int remains) {
			this.idx = idx;
			this.remains = remains;
		}
	}
}