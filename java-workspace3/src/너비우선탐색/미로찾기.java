package 너비우선탐색;

import java.util.*;

public class 미로찾기 {
    static Scanner scanner = new Scanner(System.in);
    static int maxRow;
    static int maxColumn;
    static int[][] map;
    static int[][] visited;
    static List<int[]> directions = Arrays.asList(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    );

    public static void main(String[] args) {
        maxRow = scanner.nextInt();
        maxColumn = scanner.nextInt();
        map = new int[maxRow][maxColumn];
        visited = new int[maxRow][maxColumn];
        scanner.nextLine();
        for (int row = 0; row < maxRow; row++) {
            map[row] = Arrays.stream(scanner.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int answer = bfs(0, 0);
        System.out.println(answer);
    }

    private static int bfs(int row, int column) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[row][column] = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int nextRow = current[0] + direction[0];
                int nextColumn = current[1] + direction[1];
                if (isAvailable(nextRow, nextColumn)) {
                    visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
                    queue.add(new int[]{nextRow, nextColumn});
                }
            }
        }
        return visited[maxRow - 1][maxColumn - 1];
    }

    private static boolean isAvailable(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < maxRow &&
                nextColumn >= 0 && nextColumn < maxColumn &&
                map[nextRow][nextColumn] == 1 &&
                visited[nextRow][nextColumn] == 0;
    }
}
