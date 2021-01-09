package 구현;

import java.util.*;

public class 뱀 {
    static Scanner scanner = new Scanner(System.in);
    static Queue<Turn> turns = new ArrayDeque<>();
    static Deque<int[]> snake = new ArrayDeque<>();
    static int size;
    static int[][] map;
    static Map<Integer, int[]> directions = new HashMap<>();
    static int direction = 1;

    static {
        directions.put(0, new int[]{-1, 0});
        directions.put(1, new int[]{0, 1});
        directions.put(2, new int[]{1, 0});
        directions.put(3, new int[]{0, -1});
    }

    public static void main(String[] args) {
        size = scanner.nextInt();
        int countOfApple = scanner.nextInt();
        map = new int[size][size];
        for (int i = 0; i < countOfApple; i++) {
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            map[row - 1][column - 1] = 1;
        }
        int countOfTurn = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countOfTurn; i++) {
            String[] turnInfo = scanner.nextLine().split(" ");
            turns.add(new Turn(Integer.parseInt(turnInfo[0]), turnInfo[1]));
        }
        int time = 1;
        snake.addLast(new int[]{0, 0});
        map[0][0] = -1;
        while (true) {
            int[] nextPosition = getNextPosition();
            int row = nextPosition[0];
            int column = nextPosition[1];
            if (!isAvailablePosition(row, column) || alreadyHas(row, column)) {
                break;
            }
            snake.addLast(new int[]{row, column});
            if (map[row][column] != 1) {
                snake.pollFirst();
            }
            map[row][column] = -1;

            if (!turns.isEmpty() && turns.peek().time == time) {
                Turn turn = turns.poll();
                if (turn.direction.equals("D")) {
                    direction = (direction + 1) % 4;
                } else {
                    direction = (direction + 3) % 4;
                }
            }
            time++;
        }
        System.out.println(time);
    }

    private static boolean alreadyHas(int row, int column) {
        for (int[] ints : snake) {
            if (ints[0] == row && ints[1] == column) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAvailablePosition(int row, int column) {
        return row >= 0 && row < size &&
                column >= 0 && column < size;
    }

    private static int[] getNextPosition() {
        int[] offset = directions.get(direction);
        int[] current = snake.peekLast();
        return new int[]{offset[0] + current[0], offset[1] + current[1]};
    }

    private static class Turn {
        int time;
        String direction;

        public Turn(int time, String direction) {
            this.time = time;
            this.direction = direction;
        }
    }
}
