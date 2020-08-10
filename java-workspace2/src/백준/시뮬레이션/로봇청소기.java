package 백준.시뮬레이션;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 로봇청소기 {
    private static int[] boardSize = null;
    private static int[][] board = null;
    private static int[] currentStatus = null;
    private static int answer = 0;
    private static Map<Integer, int[]> directions = new HashMap<>();

    public static void main(String[] args) {
        init();
        operate();
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        boardSize = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        currentStatus = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        board = new int[boardSize[0]][boardSize[1]];
        for (int height = 0; height < boardSize[0]; height++) {
            board[height] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        directions.put(0, new int[]{-1, 0});
        directions.put(1, new int[]{0, 1});
        directions.put(2, new int[]{1, 0});
        directions.put(3, new int[]{0, -1});
    }

    private static void operate() {
        int count = 0;
        while (true) {
            //System.out.println("current :" + currentStatus[0]+"," +currentStatus[1]);
            if (count == 4) {
                int[] nextPosition = new int[]{currentStatus[0] + (-directions.get(currentStatus[2])[0]),
                        currentStatus[1] + (-directions.get(currentStatus[2])[1])};
                if (board[nextPosition[0]][nextPosition[1]] == 0 || board[nextPosition[0]][nextPosition[1]] == 2) {
                    currentStatus[0] = nextPosition[0];
                    currentStatus[1] = nextPosition[1];
                    count = 0;
                } else {
                    break;
                }
            }
            clean();
            int nextDirection = (currentStatus[2] + 7) % 4;
            int[] nextPosition = new int[]{currentStatus[0] + directions.get(nextDirection)[0],
                    currentStatus[1] + directions.get(nextDirection)[1]};
            if (hasPlaceToBeClean(nextPosition)) {
                //System.out.println("can move");
                currentStatus[2] = nextDirection;
                currentStatus[0] += directions.get(nextDirection)[0];
                currentStatus[1] += directions.get(nextDirection)[1];
                count = 0;
            } else {
                //System.out.println("can not move");
                currentStatus[2] = nextDirection;
                count++;
            }
        }
        System.out.println(answer);
    }

    private static void clean() {
        if (board[currentStatus[0]][currentStatus[1]] == 0) {
            //System.out.println("clean " + currentStatus[0]+","+currentStatus[1]);
            board[currentStatus[0]][currentStatus[1]] = 2;
            answer++;
        }
    }

    private static boolean hasPlaceToBeClean(int[] nextPosition) {
        return isAvailablePosition(nextPosition) && board[nextPosition[0]][nextPosition[1]] == 0;
    }

    private static boolean isAvailablePosition(int[] position) {
        return position[0] > 0 && position[0] < boardSize[0] - 1 &&
                position[1] > 0 && position[1] < boardSize[1] - 1;
    }
}
