package 백준.bfs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3 {
    private static final int MAX_POSITION = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subin = scanner.nextInt();
        int sister = scanner.nextInt();
        int[] visited = new int[MAX_POSITION + 1];

        Queue<Position> queue = new PriorityQueue<>(Comparator.comparing((Position p) -> p.time));
        queue.add(new Position(subin, 0));

        while (!queue.isEmpty()) {
            Position currentSubin = queue.poll();
            if (currentSubin.position == sister) {
                break;
            }
            move(queue, visited, currentSubin.position + 1, currentSubin.position);
            move(queue, visited, currentSubin.position - 1, currentSubin.position);
            teleport(queue, visited, currentSubin.position * 2, currentSubin.position);
        }
        System.out.println(visited[sister]);
    }

    private static void move(Queue<Position> queue, int[] visited, int nextPosition, int currentPosition) {
        if (isAvailablePosition(nextPosition)) {
            if (visited[nextPosition] == 0) {
                visited[nextPosition] = visited[currentPosition] + 1;
                queue.add(new Position(nextPosition, visited[nextPosition]));
            }
        }
    }

    private static void teleport(Queue<Position> queue, int[] visited, int nextPosition, int currentPosition) {
        if (isAvailablePosition(nextPosition)) {
            if (visited[nextPosition] == 0) {
                visited[nextPosition] = visited[currentPosition];
                queue.add(new Position(nextPosition, visited[nextPosition]));
            }
        }
    }

    private static boolean isAvailablePosition(int position) {
        return position >= 0 && position <= MAX_POSITION;
    }

    private static class Position {
        private int position;
        private int time;

        public Position(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}
