package programmers.graph;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {
        solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    public static int solution(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            List<Integer> fromList = map.getOrDefault(from, new ArrayList<>());
            fromList.add(to);
            List<Integer> toList = map.getOrDefault(to, new ArrayList<>());
            toList.add(from);
            map.put(from, fromList);
            map.put(to, toList);
        }
        int answer = bfs(n, map, 1);
        System.out.println(answer);
        return answer;
    }

    private static int bfs(int n, Map<Integer, List<Integer>> map, int startPoint) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[n + 1];
        visited[startPoint] = 1;
        queue.add(startPoint);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> adj = map.get(node);
            for (Integer i : adj) {
                if (visited[i] < 1 && !queue.contains(i)) {
                    visited[i] = visited[node] + 1;
                    queue.add(i);
                }
            }
        }
        int answer = (int) Arrays.stream(visited)
                .filter(i-> i == Arrays.stream(visited).max().getAsInt())
                .count();
        return  answer;
    }
}
