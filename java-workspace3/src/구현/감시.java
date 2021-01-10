package 구현;

import java.util.*;

public class 감시 {
    static Scanner scanner = new Scanner(System.in);
    static int maxRow;
    static int maxColumn;
    static int[][] map;
    static List<int[]> camPositions = new ArrayList<>();
    static Map<Integer, List<List<Integer>>> availableDirections = new HashMap<>();
    static Map<Integer, int[]> offsets = new HashMap<>();
    static int[] directionIdx;
    static int answer = Integer.MAX_VALUE;

    static {
        availableDirections.put(1, Arrays.asList(Arrays.asList(1), Arrays.asList(2),
                Arrays.asList(3), Arrays.asList(4)));
        availableDirections.put(2, Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 4)));
        availableDirections.put(3, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3),
                Arrays.asList(3, 4), Arrays.asList(4, 1)));
        availableDirections.put(4, Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4),
                Arrays.asList(3, 4, 1), Arrays.asList(4, 1, 2)));
        availableDirections.put(5, Arrays.asList(Arrays.asList(1, 2, 3, 4)));

        offsets.put(1, new int[]{-1, 0});
        offsets.put(2, new int[]{0, 1});
        offsets.put(3, new int[]{1, 0});
        offsets.put(4, new int[]{0, -1});
    }

    public static void main(String[] args) {
        maxRow = scanner.nextInt();
        maxColumn = scanner.nextInt();
        map = new int[maxRow][maxColumn];
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                int value = scanner.nextInt();
                map[row][column] = value;
                if (value >= 1 && value <= 5) {
                    camPositions.add(new int[]{row, column});
                }
            }
        }
        directionIdx = new int[camPositions.size()];
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int camIdx) {
        if (camIdx == camPositions.size()) {
            int[][] copyMap = deepCopy(map);
            for (int cIdx = 0; cIdx < directionIdx.length; cIdx++) {
                int[] position = camPositions.get(cIdx);
                int camType = copyMap[position[0]][position[1]];
                int direction = directionIdx[cIdx];
                List<List<Integer>> lists = availableDirections.get(camType);
                List<Integer> list = lists.get(direction);
                for (Integer dir : list) {
                    watch(copyMap, position[0], position[1], dir);
                }
            }

            int safeArea = getSafeArea(copyMap);
            answer = Math.min(answer, safeArea);
            return;
        }
        int[] camPosition = camPositions.get(camIdx);
        int camType = map[camPosition[0]][camPosition[1]];
        List<List<Integer>> lists = availableDirections.get(camType);
        for (int listIdx = 0; listIdx < lists.size(); listIdx++) {
            directionIdx[camIdx] = listIdx;
            dfs(camIdx + 1);
        }
    }

    private static int getSafeArea(int[][] copyMap) {
        int count = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                if (copyMap[row][column] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void watch(int[][] copyMap, int row, int column, int direction) {
        int[] offset = offsets.get(direction);
        while (true) {
            row += offset[0];
            column += offset[1];
            if (!isAvailablePosition(row, column)) {
                break;
            }
            if (copyMap[row][column] == 6) {
                break;
            } else if (copyMap[row][column] == 0) {
                copyMap[row][column] = -1;
            }
        }
    }

    private static boolean isAvailablePosition(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < maxRow &&
                nextColumn >= 0 && nextColumn < maxColumn;
    }


    private static int[][] deepCopy(int[][] origin) {
        if (origin == null) return null;
        int[][] result = new int[origin.length][origin[0].length];

        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
        }
        return result;
    }
}
