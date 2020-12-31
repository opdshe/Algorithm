package 그래프.최단경로.다익스트라;

import java.util.*;

public class 파티 {
    static final int INF = 0xfffff;
    static Scanner scanner = new Scanner(System.in);
    static int countOfCity;
    static int countOfRoad;
    static List<Road>[] roads;

    public static void main(String[] args) {
        countOfCity = scanner.nextInt();
        countOfRoad = scanner.nextInt();
        int destination = scanner.nextInt();
        roads = new ArrayList[countOfCity + 1];
        for (int idx = 1; idx <= countOfCity; idx++) {
            roads[idx] = new ArrayList<>();
        }
        for (int i = 0; i < countOfRoad; i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            int cost = scanner.nextInt();
            roads[source].add(new Road(dest, cost));
        }
        int answer = 0;
        for (int idx = 1; idx <= countOfCity; idx++) {
            int forward = dijkstra(idx, destination);
            int backward = dijkstra(destination, idx);
            answer = Math.max(answer, forward + backward);
        }
        System.out.println(answer);
    }

    private static int dijkstra(int source, int dest) {
        int[] distance = new int[countOfCity + 1];
        Arrays.fill(distance, INF);
        distance[source] = 0;
        Queue<City> queue = new PriorityQueue<>(Comparator.comparing(city -> city.cost));
        queue.add(new City(source, 0));
        while (!queue.isEmpty()) {
            City current = queue.poll();
            for (Road road : roads[current.idx]) {
                int cost = current.cost + road.cost;
                if (distance[road.dest] > cost) {
                    distance[road.dest] = cost;
                    queue.add(new City(road.dest, cost));
                }
            }
        }
        return distance[dest];
    }

    private static class City {
        int idx;
        int cost;

        public City(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    private static class Road {
        int dest;
        int cost;

        public Road(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
