package 프로그래머스;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 경주로건설BFS {
    static int[][] board;
    static int[][] visited;
    static Direction[] directions = {
            new Direction("UP", new int[]{-1, 0}),
            new Direction("DOWN", new int[]{1, 0}),
            new Direction("LEFT", new int[]{0, -1}),
            new Direction("RIGHT", new int[]{0, 1})};

    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}});
    }

    public static int solution(int[][] input) {
        int answer = Integer.MAX_VALUE;
        board = input;
        initVisited(input);
        Queue<Road> queue = new ArrayDeque<>();
        queue.add(new Road(new int[]{0, 0},"STOP", 0));
        while (!queue.isEmpty()) {
            Road currentRoad = queue.poll();
            /*System.out.println("current position : " + Arrays.toString(currentRoad.position));
            System.out.println("current direction : " + currentRoad.direction);
            System.out.println("current cost : " + currentRoad.cost);*/
            if (Arrays.equals(currentRoad.position, new int[]{input.length - 1, input.length - 1})){
                answer = Math.min(answer, currentRoad.cost);
            }
            for (Direction direction : directions) {
                int[] nextPosition = getNextCoord(currentRoad.position, direction);
                if (isAvailableToGo(nextPosition)){
                    if (currentRoad.direction.equals("STOP")) {
                        visited[nextPosition[0]][nextPosition[1]] = 100;
                        queue.add(new Road(nextPosition, direction.directionName, 100));
                    }
                    int nextBill;
                    if (currentRoad.direction.equals(direction.directionName)) {
                        nextBill = currentRoad.cost + 100;
                    } else {
                        nextBill = currentRoad.cost + 600;
                    }

                    if (visited[nextPosition[0]][nextPosition[1]] == 0) {
                        visited[nextPosition[0]][nextPosition[1]] = nextBill;
                        queue.add(new Road(nextPosition, direction.directionName, nextBill));
                    } else if(nextBill <= visited[nextPosition[0]][nextPosition[1]]) {
                        visited[nextPosition[0]][nextPosition[1]] = nextBill;
                        queue.add(new Road(nextPosition, direction.directionName, nextBill));
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
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
                board[nextCoord[0]][nextCoord[1]] == 0;
    }

    private static void initVisited(int[][] input) {
        visited = new int[input.length][input.length];
    }

    static class Direction {
        String directionName;
        int[] offset;

        public Direction(String direction, int[] offset) {
            this.directionName = direction;
            this.offset = offset;
        }
    }

    static class Road {
        int[] position;
        String direction;
        int cost;

        public Road(int[] position, String direction, int cost) {
            this.position = position;
            this.direction = direction;
            this.cost = cost;
        }
    }
}
