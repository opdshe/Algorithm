package 백준.시뮬레이션;

import java.util.*;

public class 탈출 {
    private static int[][] directions = new int[][]{
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    };
    static int[] sonicsPosition = null;
    static int[] beaversPosition = null;
    static List<int[]> waterPosition = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = inputs[0];
        int M = inputs[1];
        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = scanner.nextLine().split("");
        }
        String answer = String.valueOf(solution(board, N, M));
        if (answer.equals("0")) {
            answer = "KAKTUS";
        }
        System.out.println(answer);
    }

    private static int solution(String[][] board, int N, int M) {
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> waterQueue = new ArrayDeque<>();
        getTargetPosition(board);
        int[][] visited = new int[board.length][board[0].length];
        queue.add(sonicsPosition);
        waterQueue.addAll(waterPosition);

        List<int[]> waterPositions = new ArrayList<>();
        while (!waterQueue.isEmpty()) {
            waterPositions.add(waterQueue.poll());
        }

        while (!waterPositions.isEmpty()) {
            int[] currentWaterPosition = waterPositions.remove(0);
            board[currentWaterPosition[0]][currentWaterPosition[1]] = "*";
            for (int[] direction : directions) {
                int[] nextWaterPosition = new int[]{currentWaterPosition[0] + direction[0],
                        currentWaterPosition[1] + direction[1]};
                if (isAvailableRange(nextWaterPosition, N, M)) {
                    if (board[nextWaterPosition[0]][nextWaterPosition[1]].equals(".") &&
                            !waterQueue.contains(nextWaterPosition) &&
                            !board[nextWaterPosition[0]][nextWaterPosition[1]].equals("*")) {
                        waterQueue.add(nextWaterPosition);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currentSonicsPosition = queue.poll();
            if (currentSonicsPosition == beaversPosition) {
                break;
            }
            waterPositions = new ArrayList<>();
            while (!waterQueue.isEmpty()) {
                waterPositions.add(waterQueue.poll());
            }
            while (!waterPositions.isEmpty()) {
                int[] currentWaterPosition = waterPositions.remove(0);
                board[currentWaterPosition[0]][currentWaterPosition[1]] = "*";
                for (int[] direction : directions) {
                    int[] nextWaterPosition = new int[]{currentWaterPosition[0] + direction[0],
                            currentWaterPosition[1] + direction[1]};
                    if (isAvailableRange(nextWaterPosition, N, M)) {
                        if (board[nextWaterPosition[0]][nextWaterPosition[1]].equals(".") &&
                                !waterQueue.contains(nextWaterPosition) &&
                                !board[nextWaterPosition[0]][nextWaterPosition[1]].equals("*")) {
                            waterQueue.add(nextWaterPosition);
                        }
                    }
                }
            }
            for (int[] direction : directions) {
                int[] nextSonicsPosition = new int[]{currentSonicsPosition[0] + direction[0],
                        currentSonicsPosition[1] + direction[1]};
                if (isAvailableRange(nextSonicsPosition, N, M)) {
                    if ((board[nextSonicsPosition[0]][nextSonicsPosition[1]].equals(".") ||
                            board[nextSonicsPosition[0]][nextSonicsPosition[1]].equals("D")) &&
                            !queue.contains(nextSonicsPosition) && visited[nextSonicsPosition[0]][nextSonicsPosition[1]] == 0) {
                        queue.add(nextSonicsPosition);
                        visited[nextSonicsPosition[0]][nextSonicsPosition[1]] = visited[currentSonicsPosition[0]][currentSonicsPosition[1]] + 1;
                    }
                }
            }
        }
        return visited[beaversPosition[0]][beaversPosition[1]];
    }

    private static void getTargetPosition(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("S")) {
                    sonicsPosition = new int[]{i, j};
                }
                if (board[i][j].equals("D")) {
                    beaversPosition = new int[]{i, j};
                }
                if (board[i][j].equals("*")) {
                    waterPosition.add(new int[]{i, j});
                }
            }
        }
    }

    private static boolean isAvailableRange(int[] position, int N, int M) {
        return position[0] >= 0 && position[0] < N && position[1] >= 0 && position[1] < M;
    }
}
