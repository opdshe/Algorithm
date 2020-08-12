package 백준.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질2 {
    private static final int MAX_POSITION = 100000;
    private static int minTime = 100000;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subin = scanner.nextInt();
        int sister = scanner.nextInt();
        int[] visited = new int[MAX_POSITION + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(subin);

        while (!queue.isEmpty()) {
            Integer currentSubin = queue.poll();
            //System.out.println("visited " + currentSubin);
            if (currentSubin == sister) {
                //System.out.println("subin == sister");
                minTime = Math.min(visited[currentSubin], minTime);
                answer++;
            }
            if (visited[currentSubin] > minTime) {
                break;
            }
            move(queue, visited, currentSubin + 1, currentSubin, sister);
            move(queue, visited, currentSubin - 1, currentSubin, sister);
            move(queue, visited, currentSubin * 2, currentSubin, sister);
        }
        System.out.println(minTime);
        System.out.println(answer);
    }

    private static void move(Queue<Integer> queue, int[] visited, int nextPosition,
                             int currentPosition, int sister) {
        if (isAvailablePosition(nextPosition)) {
            if (visited[nextPosition] == 0) {
                queue.add(nextPosition);
                visited[nextPosition] = visited[currentPosition] + 1;
            } else if (visited[nextPosition] == visited[currentPosition] + 1) {
                queue.add(nextPosition);
                visited[nextPosition] = visited[currentPosition] + 1;
            }
        }
    }

    private static boolean isAvailablePosition(int position) {
        return position >= 0 && position <= MAX_POSITION;
    }
}
