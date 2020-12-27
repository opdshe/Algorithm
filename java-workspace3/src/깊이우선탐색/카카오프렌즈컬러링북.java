package 깊이우선탐색;

import java.util.Arrays;
import java.util.List;

public class 카카오프렌즈컬러링북 {
    static List<int[]> directions = Arrays.asList(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    );
    static int maxRow;
    static int maxColumn;
    static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        maxRow = m;
        maxColumn = n;
        visited = new boolean[m][n];
        int countOfArea = 0;
        int maxArea = 0;
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (picture[row][column] > 0 && !visited[row][column]) {
                    countOfArea++;
                    maxArea = Math.max(maxArea, dfs(picture, row, column, picture[row][column]));
                }
            }
        }
        return new int[]{countOfArea, maxArea};
    }

    private static int dfs(int[][] picture, int row, int column, int color) {
        visited[row][column] = true;
        int sum = 1;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (isAvailable(nextRow, nextColumn) && picture[nextRow][nextColumn] == color) {
                sum += dfs(picture, nextRow, nextColumn, color);
            }
        }
        return sum;
    }

    private static boolean isAvailable(int row, int column) {
        return row >= 0 && row < maxRow &&
                column >= 0 && column < maxColumn &&
                !visited[row][column];
    }
}
