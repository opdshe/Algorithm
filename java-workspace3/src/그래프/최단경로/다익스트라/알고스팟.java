package 그래프.최단경로.다익스트라;

import java.util.*;

public class 알고스팟 {
    static final int INF = Integer.MAX_VALUE;
    static Scanner scanner = new Scanner(System.in);
    static int maxRow;
    static int maxColumn;
    static int[][] map;
    static List<int[]> directions = Arrays.asList(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    );

    public static void main(String[] args) {
        maxColumn = scanner.nextInt();
        maxRow = scanner.nextInt();
        map = new int[maxRow][maxColumn];
        scanner.nextLine();
        for (int row = 0; row < maxRow; row++) {
            map[row] = Arrays.stream(scanner.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int answer = dijkstra();
        System.out.println(answer);
    }

    private static int dijkstra() {
        int[][] distances = new int[maxRow][maxColumn];
        for (int row = 0; row < maxRow; row++) {
            Arrays.fill(distances[row], INF);
        }
        distances[0][0] = 0;
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.destroy));
        queue.add(new Node(new int[]{0, 0}, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (distances[current.position[0]][current.position[1]] < current.destroy) {
                continue;
            }
            for (int[] direction : directions) {
                int nextRow = current.position[0] + direction[0];
                int nextColumn = current.position[1] + direction[1];
                if (isAvailable(nextRow, nextColumn)) {
                    int cost = current.destroy + map[nextRow][nextColumn];
                    if (distances[nextRow][nextColumn] > cost) {
                        distances[nextRow][nextColumn] = cost;
                        queue.add(new Node(new int[]{nextRow, nextColumn}, cost));
                    }
                }
            }
        }
        return distances[maxRow - 1][maxColumn - 1];
    }

    private static boolean isAvailable(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < maxRow &&
                nextColumn >= 0 && nextColumn < maxColumn;
    }

    private static class Node {
        int[] position;
        int destroy;

        public Node(int[] position, int destroy) {
            this.position = position;
            this.destroy = destroy;
        }
    }
}
