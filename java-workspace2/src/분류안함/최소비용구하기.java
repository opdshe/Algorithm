package 분류안함;

import java.util.*;

public class 최소비용구하기 {
	static Scanner scanner = new Scanner(System.in);
	static List<Bus>[] buses;

	public static void main(String[] args) {
		int countOfCity = scanner.nextInt();
		int countOfBus = scanner.nextInt();
		buses = new ArrayList[countOfCity + 1];
		for (int idx = 1; idx <= countOfCity; idx++) {
			buses[idx] = new ArrayList<>();
		}
		for (int bus = 1; bus <= countOfBus; bus++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			buses[source].add(new Bus(dest, cost));
		}
		int source = scanner.nextInt();
		int dest = scanner.nextInt();
		solution(countOfCity, source, dest);
	}

	private static void solution(int countOfCity, int source, int dest) {
		int INF = Integer.MAX_VALUE;
		int[] distance = new int[countOfCity + 1];
		distance[source] = 0;

		Queue<City> queue = new PriorityQueue<>(Comparator.comparing(city -> city.cost));
		Arrays.fill(distance, INF);
		queue.add(new City(source, 0));

		int answer = INF;
		while (!queue.isEmpty()) {
			City current = queue.poll();
			if (distance[current.idx] < current.cost) {
				continue;
			}
			if (current.idx == dest) {
				answer = Math.min(answer, current.cost);
			}
			for (Bus bus : buses[current.idx]) {
				int cost = current.cost + bus.cost;
				if (distance[bus.dest] > cost) {
					distance[bus.dest] = cost;
					queue.add(new City(bus.dest, cost));
				}
			}
		}
		System.out.println(answer);
	}

	private static class City {
		private int idx;
		private int cost;

		public City(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	private static class Bus {
		private int dest;
		private int cost;

		public Bus(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
