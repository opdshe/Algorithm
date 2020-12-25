package 구현;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 삼각달팽이 {
    //1: 남, 2: 동, 3: 북서
    static Map<Integer, int[]> offsets = new HashMap<>();
    static int direction = 1;
    static int y = 0;
    static int x = 0;

    static {
        offsets.put(1, new int[]{1, 0});
        offsets.put(2, new int[]{0, 1});
        offsets.put(3, new int[]{-1, -1});
    }

    public static void main(String[] args) {
        solution(4);
    }

    public static int[] solution(int n) {
        int maxNumber = n * (n + 1) / 2;
        int[][] map = new int[n][n];
        for (int number = 1; number <= maxNumber; number++) {
            map[y][x] = number;
            int[] offset = offsets.get(direction);
            int nextY = y + offset[0];
            int nextX = x + offset[1];
            if (!isAvailablePosition(n, nextY, nextX) || map[nextY][nextX] != 0) {
                direction = (direction % 3) + 1;
                offset = offsets.get(direction);
                nextY = y + offset[0];
                nextX = x + offset[1];
            }
            y = nextY;
            x = nextX;
        }
        List<Integer> answer = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (map[row][column] != 0) {
                    answer.add(map[row][column]);
                }
            }
        }
        return answer.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static boolean isAvailablePosition(int n, int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < n &&
                nextColumn >= 0 && nextColumn < n;
    }
}
