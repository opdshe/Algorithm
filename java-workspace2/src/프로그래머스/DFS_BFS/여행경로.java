package 프로그래머스.DFS_BFS;

import java.util.Arrays;

public class 여행경로 {
    static String start = "ICN";
    static int[] visited;
    static int answer = 0;

    public static void main(String[] args) {
        solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
    }

    public static String[] solution(String[][] tickets) {
        visited = new int[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start)) {
                dfs(tickets, start, i, 0);
            }
        }
        System.out.println(answer);
        return null;
    }

    private static void dfs(String[][] tickets, String place, int idx, int order) {
        System.out.println("arrive " + place);
        System.out.println(idx);
        visited[idx] = order;
        if (order == tickets.length - 1) {
            System.out.println(Arrays.toString(visited));
            answer++;
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            String source = tickets[i][0];
            String dest = tickets[i][1];

            if (source.equals(place) && visited[i] == 0) {
                dfs(tickets, dest, i, order + 1);
            }
        }
    }
}