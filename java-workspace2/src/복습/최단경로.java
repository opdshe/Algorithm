package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = Integer.parseInt(bufferedReader.readLine());
        List<Edge>[] edges = new ArrayList[inputs[0] + 1];
        for (int v = 1; v <= inputs[0]; v++) {
            edges[v] = new ArrayList<>();
        }
        for (int i = 0; i < inputs[1]; i++) {
            int[] data = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            edges[data[0]].add(new Edge(data[1], data[2]));
        }
        solution(edges, inputs[0], start);
    }

    private static void solution(List<Edge>[] edges, int countOfVertex, int start) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[countOfVertex + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        Queue<Vertex> queue = new PriorityQueue<>(Comparator.comparing(vertex -> vertex.cost));
        queue.add(new Vertex(start, 0));

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current.cost > distance[current.idx]) {
                continue;
            }
            for (Edge edge : edges[current.idx]) {
                int cost = current.cost + edge.cost;
                if (distance[edge.dest] > cost) {
                    distance[edge.dest] = cost;
                    queue.add(new Vertex(edge.dest, cost));
                }
            }
        }
        for (int vertex = 1; vertex <= countOfVertex; vertex++) {
            System.out.println(distance[vertex] == INF ? "INF" : distance[vertex]);
        }
    }

    private static class Vertex {
        private int idx;
        private int cost;

        public Vertex(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    private static class Edge {
        private int dest;
        private int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
