package 복습;

import java.util.*;

public class 치킨배달 {
	static Scanner scanner = new Scanner(System.in);
	static List<int[]> restaurants = new ArrayList<>();
	static List<int[]> houses = new ArrayList<>();
	static int size;
	static int countOfRemovedRestaurants;
	static int countOfRemainingRestaurants;
	static int[][] map;
	static int[] removeRestaurantIdx;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int countOfRestaurants = 0;
		size = scanner.nextInt();
		countOfRemainingRestaurants = scanner.nextInt();
		map = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				int value = scanner.nextInt();
				map[row][column] = value;
				if (value == 2) {
					countOfRestaurants++;
					restaurants.add(new int[]{row, column});
				} else if (value == 1) {
					houses.add(new int[]{row, column});
				}
			}
		}
		countOfRemovedRestaurants = countOfRestaurants - countOfRemainingRestaurants;
		removeRestaurantIdx = new int[countOfRemovedRestaurants];

		combine(0, 0);
		System.out.println(answer);
	}

	private static void combine(int level, int start) {
		if (level == countOfRemovedRestaurants) {
			Set<Integer> removeSet = new HashSet<>();
			for (int idx = 0; idx < countOfRemovedRestaurants; idx++) {
				removeSet.add(removeRestaurantIdx[idx]);
			}
			int sumOfChickenDistance = 0;
			for (int[] house : houses) {
				int chickenDistance = Integer.MAX_VALUE;
				for (int restaurantIdx = 0; restaurantIdx < restaurants.size(); restaurantIdx++) {
					if (!removeSet.contains(restaurantIdx)) {
						int[] position = restaurants.get(restaurantIdx);
						int distance = Math.abs(house[0] - position[0]) + Math.abs(house[1] - position[1]);
						chickenDistance = Math.min(chickenDistance, distance);
					}
				}
				sumOfChickenDistance += chickenDistance;
			}
			answer = Math.min(answer, sumOfChickenDistance);
			return;
		}
		for (int idx = start; idx < restaurants.size(); idx++) {
			removeRestaurantIdx[level] = idx;
			combine(level + 1, idx + 1);
		}
	}
}
