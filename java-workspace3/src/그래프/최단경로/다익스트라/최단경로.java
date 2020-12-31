package 그래프.최단경로.다익스트라;

import java.util.*;

public class 최단경로 {
    static Scanner scanner = new Scanner(System.in);
    static List<Edge>[] edges;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int countOfVertex = scanner.nextInt();
        int countOfEdge = scanner.nextInt();
        int start = scanner.nextInt();
        edges = new ArrayList[countOfVertex + 1];
        for (int idx = 1; idx <= countOfVertex; idx++) {
            edges[idx] = new ArrayList<>();
        }
        for (int i = 0; i < countOfEdge; i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            int cost = scanner.nextInt();
            edges[source].add(new Edge(dest, cost));
        }
        int[] distances = new int[countOfVertex + 1];
        dijkstra(distances, start);
        for (int idx = 1; idx <= countOfVertex; idx++) {
            System.out.println(distances[idx] == INF ? "INF" : distances[idx]);
        }
    }

    private static void dijkstra(int[] distances, int start) {
        Arrays.fill(distances, INF);
        distances[start] = 0;
        Queue<Vertex> queue = new PriorityQueue<>(Comparator.comparing(vertex -> vertex.cost));
        queue.add(new Vertex(start, 0));
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current.cost > distances[current.idx]) {
                continue;
            }
            for (Edge edge : edges[current.idx]) {
                int cost = current.cost + edge.cost;
                if (distances[edge.dest] > cost) {
                    distances[edge.dest] = cost;
                    queue.add(new Vertex(edge.dest, cost));
                }
            }
        }
    }

    private static class Vertex {
        int idx;
        int cost;

        public Vertex(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    private static class Edge {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
