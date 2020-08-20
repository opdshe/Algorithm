package 프로그래머스.DFS_BFS;

public class 네트워크 {
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) {
        solution(5, new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}});
    }

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(n, computers, i);
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static void dfs(int n, int[][] computers, int computerIdx) {
        visited[computerIdx] = true;
        for (int idx = 0; idx < n; idx++) {
            if (computers[computerIdx][idx] == 1 && !visited[idx] && idx != computerIdx) {
                dfs(n, computers, idx);
            }
        }
    }
}