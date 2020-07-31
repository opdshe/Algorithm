package 프로그래머스;

import java.util.ArrayDeque;
import java.util.Queue;

public class 네트워크2 {
    public static void main(String[] args) {
        solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    public static int solution(int n, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer computerIdx = queue.poll();
                    visited[computerIdx] = true;
                    for (int adjIdx = 0; adjIdx < n; adjIdx++) {
                        if (!visited[adjIdx] && computers[computerIdx][adjIdx]==1 && !queue.contains(adjIdx)) {
                            queue.add(adjIdx);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
