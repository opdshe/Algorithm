package 완전탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 치킨배달 {
	static Scanner scanner = new Scanner(System.in);
	static List<Restaurant> restaurants = new ArrayList<>();
	static List<Home> homes = new ArrayList<>();
	static int N;
	static int M;
	static int[][] map;

	static boolean[] visited;
	static int[] array;
	static int answer = 0xfffffff;

	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		map = new int[N][N];
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {
				map[row][column] = scanner.nextInt();
				if (map[row][column] == 2) {
					restaurants.add(new Restaurant(row, column));
				} else if (map[row][column] == 1) {
					homes.add(new Home(row, column));
				}
			}
		}
		combine(M);
		System.out.println(answer);
	}

	private static void combine(int n) {
		visited = new boolean[restaurants.size()];
		array = new int[n];
		dfs(0, 0);
	}

	private static void dfs(int start, int level) {
		if (level == array.length) {
			List<Restaurant> restaurantList = new ArrayList<>();
			for (int value : array) {
				restaurantList.add(restaurants.get(value));
			}
			homes.forEach(home -> home.setChickenDistance(restaurantList));
			int sum = homes.stream()
					.map(home -> home.chickenDistance)
					.reduce(Integer::sum)
					.get();
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = start; i < restaurants.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[level] = i;
				dfs(i + 1, level + 1);
				visited[i] = false;
			}
		}
	}

	private static int getDistance(Home home, Restaurant restaurant) {
		return Math.abs(home.y - restaurant.y) + Math.abs(home.x - restaurant.x);
	}

	private static class Home {
		private int y;
		private int x;
		private int chickenDistance = 0xfffffff;

		public Home(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public void setChickenDistance(List<Restaurant> restaurants) {
			this.chickenDistance = 0xfffffff;
			for (Restaurant restaurant : restaurants) {
				this.chickenDistance = Math.min(chickenDistance, getDistance(this, restaurant));
			}
		}
	}

	private static class Restaurant {
		private int y;
		private int x;

		public Restaurant(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
