package 프로그래머스;

import java.util.ArrayDeque;
import java.util.Deque;

public class 네트워크 {
    public static void main(String[] args) {
        solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        Deque<Integer> queue = new ArrayDeque<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                answer++;
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    int node = queue.pollFirst();
                    visited[node] = true;
                    for (int j = 0; j < n; j++) {
                        if (computers[node][j]==1 && !visited[j] && !queue.contains(j)){
                            queue.addLast(j);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
