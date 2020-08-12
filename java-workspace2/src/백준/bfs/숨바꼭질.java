package 백준.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subin = scanner.nextInt();
        int sister = scanner.nextInt();

        int[] visited = new int[100000 + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(subin);

        while (!queue.isEmpty()) {
            Integer currentSubin = queue.poll();
            if (currentSubin == sister) {
                break;
            }
            move(queue, visited, currentSubin + 1, currentSubin);
            move(queue, visited, currentSubin - 1, currentSubin);
            move(queue, visited, currentSubin * 2, currentSubin);

        }
        System.out.println(visited[sister]);
    }

    private static void move(Queue<Integer> queue, int[] visited, int nextPosition, int currentPosition) {
        if (isAvailablePosition(nextPosition)) {
            if (visited[nextPosition] == 0 && !queue.contains(nextPosition)) {
                queue.add(nextPosition);
                visited[nextPosition] = visited[currentPosition] + 1;
            }
        }
    }

    private static boolean isAvailablePosition(int position) {
        return position >= 0 && position <= 100000;
    }
}
