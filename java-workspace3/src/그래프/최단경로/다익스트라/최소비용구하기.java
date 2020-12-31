package 그래프.최단경로.다익스트라;

import java.util.*;

public class 최소비용구하기 {
    static final int INF = Integer.MAX_VALUE;
    static Scanner scanner = new Scanner(System.in);
    static List<Bus>[] buses;

    public static void main(String[] args) {
        int countOfCity = scanner.nextInt();
        int countOfBus = scanner.nextInt();
        buses = new ArrayList[countOfCity + 1];
        for (int idx = 1; idx <= countOfCity; idx++) {
            buses[idx] = new ArrayList<>();
        }
        for (int i = 0; i < countOfBus; i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            int cost = scanner.nextInt();
            buses[source].add(new Bus(dest, cost));
        }
        int start = scanner.nextInt();
        int dest = scanner.nextInt();
        int[] distances = new int[countOfCity + 1];
        int answer = dijkstra(distances, start, dest);
        System.out.println(answer);
    }

    private static int dijkstra(int[] distances, int start, int dest) {
        Queue<City> queue = new PriorityQueue<>(Comparator.comparing(city -> city.cost));
        Arrays.fill(distances, INF);
        queue.add(new City(start, 0));
        while (!queue.isEmpty()) {
            City current = queue.poll();
            if (distances[current.idx] < current.cost) {
                continue;
            }
            for (Bus bus : buses[current.idx]) {
                int cost = current.cost + bus.cost;
                if (distances[bus.dest] > cost) {
                    distances[bus.dest] = cost;
                    queue.add(new City(bus.dest, cost));
                }
            }
        }
        return distances[dest];
    }

    private static class City {
        int idx;
        int cost;

        public City(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    private static class Bus {
        int dest;
        int cost;

        public Bus(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
