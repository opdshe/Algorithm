package programmers.kakaoBlindRecruit_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
아직 미완성
*/
public class 블록이동하기 {
    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}});
    }

    public static int solution(int[][] board) {
        int n = board.length;
        System.out.println("n = " + n);
        int[][] visited = new int[n][n];
        bfs(n, board, visited);
        for (int[] line : visited) {
            System.out.println(Arrays.toString(line));
        }
        int answer = 0;
        return answer;
    }

    private static void bfs(int n, int[][] board, int[][] visited) {
        Robot robot = new Robot();
        Queue<Robot> queue = new ArrayDeque();
        queue.add(robot);
        int count = 1;
        while (!queue.isEmpty()) {
            Robot polledRobot = queue.poll();
            Coord currentFront = polledRobot.front;
            Coord currentBack = polledRobot.back;
            System.out.println("currentFront : " + currentFront.row + ", " + currentFront.column +" currentBack : " + currentBack.row + ", " + currentBack.column +" count : " +count );
            visited[currentFront.row][currentFront.column] = count;
            visited[currentBack.row][currentBack.column] = count;
            //앞
            if (isAvailableToMove(n, board, visited, new Coord(currentFront.row, currentFront.column + 1), new Coord(currentBack.row, currentBack.column + 1))) {
                queue.add(new Robot(new Coord(currentFront.row, currentFront.column + 1), new Coord(currentBack.row, currentBack.column + 1)));
            }
            //뒤
            if (isAvailableToMove(n, board, visited, new Coord(currentFront.row, currentFront.column - 1), new Coord(currentBack.row, currentBack.column - 1))) {
                queue.add(new Robot(new Coord(currentFront.row, currentFront.column - 1), new Coord(currentBack.row, currentBack.column - 1)));
            }
            //상
            if (isAvailableToMove(n, board, visited, new Coord(currentFront.row - 1, currentFront.column), new Coord(currentBack.row - 1, currentBack.column))) {
                queue.add(new Robot(new Coord(currentFront.row - 1, currentFront.column), new Coord(currentBack.row - 1, currentBack.column)));
            }
            //하
            if (isAvailableToMove(n, board, visited, new Coord(currentFront.row + 1, currentFront.column), new Coord(currentBack.row + 1, currentBack.column))) {
                queue.add(new Robot(new Coord(currentFront.row + 1, currentFront.column), new Coord(currentBack.row + 1, currentBack.column)));
            }
            //백을 위로
            if (isAvailableToMove(n, board, visited, new Coord(currentFront.row, currentFront.column), new Coord(currentFront.row - 1, currentFront.column))
                    && board[currentBack.row - 1][currentBack.column] == 0) {
                queue.add(new Robot(new Coord(currentFront.row, currentFront.column), new Coord(currentFront.row - 1, currentFront.column)));
            }
            //백을 아래로
            if (isAvailableToMove(n, board, visited, new Coord(currentFront.row, currentFront.column), new Coord(currentFront.row + 1, currentFront.column))
                    && board[currentBack.row + 1][currentBack.column] == 0) {
                queue.add(new Robot(new Coord(currentFront.row, currentFront.column), new Coord(currentFront.row + 1, currentFront.column)));
            }
            //프론트를 위로
            if (isAvailableToMove(n, board, visited, new Coord(currentBack.row - 1, currentBack.column), new Coord(currentBack.row, currentBack.column))
                    && board[currentFront.row - 1][currentBack.column] == 0) {
                queue.add(new Robot(new Coord(currentBack.row - 1, currentBack.column), new Coord(currentBack.row, currentBack.column)));
            }
            //프론트를 아래로
            if (isAvailableToMove(n, board, visited, new Coord(currentBack.row + 1, currentBack.column), new Coord(currentBack.row, currentBack.column))
                    && board[currentFront.row + 1][currentBack.column] == 0) {
                queue.add(new Robot(new Coord(currentBack.row + 1, currentBack.column), new Coord(currentBack.row, currentBack.column)));
            }
            count++;
        }
    }

    private static boolean isAvailableToMove(int n, int[][] board, int[][] visited, Coord nextFront, Coord nextBack) {
        if (!validateRange(n, nextFront, nextBack)) {
            return false;
        }
        if (!validateBoard(n, board, nextFront, nextBack)) {
            return false;
        }
        return validateVisited(visited, nextFront, nextBack);
    }

    private static boolean validateRange(int n, Coord nextFront, Coord nextBack) {
        return nextFront.row >= 0 && nextFront.row < n && nextFront.column >= 0 && nextFront.column < n
                && nextBack.row >= 0 && nextBack.row < n && nextBack.column >= 0 && nextBack.column < n;
    }

    private static boolean validateBoard(int n, int[][] board, Coord nextFront, Coord nextBack) {
        return board[nextFront.row][nextFront.column] == 0 && board[nextBack.row][nextBack.column] == 0;
    }

    private static boolean validateVisited(int[][] visited, Coord nextFront, Coord nextBack) {
        return !(visited[nextFront.row][nextFront.column] >=1 && visited[nextBack.row][nextBack.column] >=1);
    }

    private static class Coord {
        int row;
        int column;

        public Coord(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private static class Robot {
        Coord front = new Coord(0, 1);
        Coord back = new Coord(0, 0);

        public Robot() {
        }

        public Robot(Coord front, Coord back) {
            this.front = front;
            this.back = back;
        }
    }
}
