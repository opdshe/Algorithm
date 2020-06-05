package programmers.maester;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임맵최단거리 {
    private static int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
    }

    public static int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        int[][] visited = new int[n][n];
        bfs(maps, visited, m, n, 0, 0);
        int answer;
        if (visited[m - 1][n - 1] > 0) {
            answer = visited[m - 1][n - 1];
        } else {
            answer = -1;
        }
        System.out.println(answer);
        return answer;
    }

    private static void bfs(int[][] maps, int[][] visited, int m, int n, int row, int column) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, column});
        visited[row][column] = 1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int currentRow = node[0];
            int currentColumn = node[1];
            if (currentRow == m - 1 && currentColumn == n - 1) {
                break;
            }
            System.out.println("row =" + currentRow + ", " + "column =" + currentColumn);
            for (int[] change : move) {
                int nextRow = currentRow + change[0];
                int nextColumn = currentColumn + change[1];
                if (validate(maps, visited, m, n, nextRow, nextColumn)
                        && !queue.contains(new int[]{nextRow, nextColumn})) {
                    queue.add(new int[]{nextRow, nextColumn});
                    visited[nextRow][nextColumn] = visited[currentRow][currentColumn] + 1;
                }
            }
        }
    }

    private static boolean validate(int[][] maps, int[][] visited, int m, int n, int nextRow, int nextColumn) {
        return validateRange(m, n, nextRow, nextColumn) && validateVisit(visited, nextRow, nextColumn)
                && validateMap(maps, nextRow, nextColumn);
    }

    private static boolean validateRange(int m, int n, int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < m && nextColumn >= 0 && nextColumn < n;
    }

    private static boolean validateVisit(int[][] visited, int nextRow, int nextColumn) {
        return visited[nextRow][nextColumn] < 1;
    }

    private static boolean validateMap(int[][] maps, int nextRow, int nextColumn) {
        return maps[nextRow][nextColumn] == 1;
    }
}
