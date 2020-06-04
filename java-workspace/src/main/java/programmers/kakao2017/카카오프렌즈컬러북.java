package programmers.kakao2017;

import java.util.*;

/*
m = row, n = column
*/
public class 카카오프렌즈컬러북 {
    public static void main(String[] args) {
        solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
    }

    public static int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] > 0) {
                    answer.add(bfs(m, n, picture, visited, i, j, picture[i][j]));
                }
            }
        }
        int count = answer.size();
        int max = answer.stream()
                .max((a, b) -> a.compareTo(b))
                .get();
        int[] ans = new int[]{count, max};
        System.out.println(answer.toString());
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private static int bfs(int m, int n, int[][] picture, boolean[][] visited, int row, int column, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, column});
        visited[row][column] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            int currentRow = coord[0];
            int currentColumn = coord[1];
            System.out.println("current =" + currentRow +", " + currentColumn);
            count++;
            //상
            if (validate(m, n, picture, visited, currentRow - 1, currentColumn, color)) {
                visited[currentRow - 1][currentColumn] = true;
                queue.add(new int[]{currentRow - 1, currentColumn});
            }
            //하
            if (validate(m, n, picture, visited, currentRow + 1, currentColumn, color)) {
                visited[currentRow + 1][currentColumn] = true;
                queue.add(new int[]{currentRow + 1, currentColumn});
            }
            //좌
            if (validate(m, n, picture, visited, currentRow, currentColumn - 1, color)) {
                visited[currentRow][currentColumn - 1] = true;
                queue.add(new int[]{currentRow, currentColumn - 1});
            }
            //우
            if (validate(m, n, picture, visited, currentRow, currentColumn + 1, color)) {
                visited[currentRow][currentColumn + 1] = true;
                queue.add(new int[]{currentRow, currentColumn + 1});
            }
        }
        System.out.println("=================");
        return count;
    }


    private static boolean validate(int m, int n, int[][] picture, boolean[][] visited, int nextRow, int nextColumn, int color) {
         if(!validateRange(m, n, nextRow, nextColumn)){
             System.out.println("rangeError : " + nextRow +", " + nextColumn);
             return false;
         }
          if (!validateVisited(visited, nextRow, nextColumn)){
              System.out.println("visitedError : " + nextRow +", " + nextColumn);
              return false;
          }
           if(!validateColor(picture, nextRow, nextColumn, color)){
               System.out.println("ColorError : " + nextRow +", " + nextColumn);
               return  false;
           }
           return  true;
    }

    private static boolean validateRange(int m, int n, int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < m && nextColumn >= 0 && nextColumn < n;
    }

    private static boolean validateVisited(boolean[][] visited, int nextRow, int nextColumn) {
        return !visited[nextRow][nextColumn];
    }

    private static boolean validateColor(int[][] picture, int nextRow, int nextColumn, int color) {
        return picture[nextRow][nextColumn] == color;
    }
}
