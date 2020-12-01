package 구현;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 삼각달팽이 {
    enum Direction {
        SOUTH(1, 0),
        EAST(0, 1),
        NORTHWEST(-1, -1);

        private int y;
        private int x;

        Direction(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Map<Direction, Direction> nextDirection = new HashMap<>();

    static {
        nextDirection.put(Direction.SOUTH, Direction.EAST);
        nextDirection.put(Direction.EAST, Direction.NORTHWEST);
        nextDirection.put(Direction.NORTHWEST, Direction.SOUTH);
    }

    public static void main(String[] args) {


    }

    public int[] solution(int n) {
        List<Integer> answers = new ArrayList<>();
        Direction direction = Direction.SOUTH;
        int max = n * (n + 1) / 2;
        int[][] values = new int[n][n];
        int y = 0;
        int x = 0;
        for (int target = 1; target <= max; target++) {
            values[y][x] = target;
            int nextY = y + direction.y;
            int nextX = x + direction.x;
            if (!isAvailablePosition(n, nextY, nextX) || values[nextY][nextX] != 0) {
                direction = nextDirection.get(direction);
            }
            y = y + direction.y;
            x = x + direction.x;
        }

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (values[row][column] != 0) {
                    answers.add(values[row][column]);
                }
            }
        }
        return answers.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static boolean isAvailablePosition(int n, int y, int x) {
        return y >= 0 && y < n &&
                x >= 0 && x < n;
    }
}
