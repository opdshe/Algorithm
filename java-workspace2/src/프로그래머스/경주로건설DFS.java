package 프로그래머스;

import java.util.Arrays;
import java.util.List;

public class 경주로건설DFS {
    static int[][] board;
    static boolean [][] visited;
    static int answer = Integer.MAX_VALUE;
    static Direction[] directions = {
            new Direction("UP", new int[]{-1, 0}),
            new Direction("DOWN", new int[]{1, 0}),
            new Direction("LEFT", new int[]{0, -1}),
            new Direction("RIGHT", new int[]{0, 1})};

    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
    }

    public static int solution(int[][] input) {
        board = input;
        initVisited(input);
        dfs(new int[]{0, 0}, new Direction("STOP", new int[]{0,0}), 0);
        System.out.println(answer);
        return answer;
    }

    private static void dfs(int[] currentPosition, Direction currentDirection, int sum) {
        visited[currentPosition[0]][currentPosition[1]] =true;
        if (answer <= sum) {
            visited[currentPosition[0]][currentPosition[1]] = false;
            return;
        }
        //System.out.println("current : " + Arrays.toString(currentPosition) + "sum : " + sum);
        if (Arrays.equals(currentPosition, new int[]{board.length - 1, board.length - 1})){
            //System.out.println("arrived !! sum = " + sum );
            answer = Math.min(answer, sum);
            visited[currentPosition[0]][currentPosition[1]] = false;
            return;
        }
        for (Direction direction : directions) {
            int[] nextCoord = getNextCoord(currentPosition, direction);
            if (isAvailableToGo(nextCoord)) {
                if(currentDirection == direction){
                    dfs(nextCoord, currentDirection, sum + 100);
                } else {
                    if (currentDirection.direction.equals("STOP")) {
                        dfs(nextCoord, direction, sum + 100);
                        continue;
                    }
                    dfs(nextCoord, direction, sum + 600);
                }
            }
        }
        visited[currentPosition[0]][currentPosition[1]] = false;
    }

    static class Direction {
        String direction;
        int[] offset;

        public Direction(String direction, int[] offset) {
            this.direction = direction;
            this.offset = offset;
        }
    }

    private static int[] getNextCoord(int[] currentPosition, Direction direction) {
        int[] nextCoord = new int[2];
        nextCoord[0] = currentPosition[0] + direction.offset[0];
        nextCoord[1] = currentPosition[1] + direction.offset[1];
        return nextCoord;
    }

    private static boolean isAvailableToGo(int[] nextCoord) {
        return nextCoord[0] >= 0 && nextCoord[0] < board.length &&
                nextCoord[1] >= 0 && nextCoord[1] < board.length &&
                board[nextCoord[0]][nextCoord[1]] == 0 && !visited[nextCoord[0]][nextCoord[1]];
    }

    private static void initVisited(int[][] input) {
        visited = new boolean[input.length][input.length];
    }
}
