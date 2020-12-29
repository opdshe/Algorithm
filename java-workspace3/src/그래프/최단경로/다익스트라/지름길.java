package 그래프.최단경로.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 지름길 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, List<Road>> roads = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < input[0]; i++) {
            int[] roadInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            List<Road> road = roads.getOrDefault(roadInfo[0], new ArrayList<>());
            road.add(new Road(roadInfo[1], roadInfo[2]));
            roads.put(roadInfo[0], road);
        }
        int answer = solution(input[1]);
        System.out.println(answer);
    }

    private static int solution(int destination) {
        int[] distance = new int[10001];
        for (int idx = 0; idx <= 10000; idx++) {
            distance[idx] = idx;
        }
        for (int idx = 0; idx <= 10000; idx++) {
            if (idx > destination) {
                break;
            }
            applyShortPath(distance, destination, idx);
        }
        return distance[destination];
    }

    private static void applyShortPath(int[] distance, int destination, int current) {
        List<Road> roadList = roads.getOrDefault(current, new ArrayList<>());
        if (roadList.size() > 0) {
            for (Road road : roadList) {
                if (destination >= road.dest) {
                    distance[road.dest] = Math.min(distance[road.dest], distance[current] + road.cost);
                    distance[destination] = Math.min(distance[destination], distance[road.dest] + destination - road.dest);
                }
            }
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
