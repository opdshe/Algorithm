package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 로봇 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int row;
    static int column;
    static int[][] map;
    static Robot robot;
    static int[] directions;
    static Map<Integer, int[]> offset = new HashMap<>();
    static boolean isContinue = true;

    static {
        offset.put(1, new int[]{-1, 0});
        offset.put(2, new int[]{1, 0});
        offset.put(3, new int[]{0, -1});
        offset.put(4, new int[]{0, 1});
    }

    public static void main(String[] args) throws IOException {
        init();
        robot.visit();
        do {
            robot.move();
        } while (isContinue);
        System.out.println(robot.row + " " + robot.column);
    }

    private static void init() throws IOException {
        int[] size = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        row = size[0];
        column = size[1];
        map = new int[row][column];

        int countOfWall = Integer.parseInt(br.readLine());
        for (int i = 0; i < countOfWall; i++) {
            int[] position = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            map[position[0]][position[1]] = -1;
        }

        int[] robotPosition = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        directions = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        robot = new Robot(robotPosition[0], robotPosition[1], 0);
    }

    private static boolean isAvailablePosition(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < row &&
                nextColumn >= 0 && nextColumn < column &&
                map[nextRow][nextColumn] == 0;
    }

    private static void terminate() {
        isContinue = false;
    }

    private static class Robot {
        int row;
        int column;
        int directionIdx;

        public Robot(int row, int column, int directionIdx) {
            this.row = row;
            this.column = column;
            this.directionIdx = directionIdx;
        }

        public void move() {
            int count = 0;
            do {
                int[] directionOffset = offset.get(directions[this.directionIdx]);
                int nextRow = row + directionOffset[0];
                int nextColumn = column + directionOffset[1];
                if (isAvailablePosition(nextRow, nextColumn)) {
                    this.row = nextRow;
                    this.column = nextColumn;
                    visit();
                    break;
                } else {
                    directionIdx = getNextDirection();
                    count++;
                    if (count == 4) {
                        terminate();
                        break;
                    }
                }
            } while (true);
        }

        public void visit() {
            map[this.row][this.column] = 1;
        }

        public int getNextDirection() {
            return (this.directionIdx + 1) % 4;
        }
    }
}
