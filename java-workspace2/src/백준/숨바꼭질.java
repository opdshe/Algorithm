package 백준;

import java.util.*;

public class 숨바꼭질 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int subinPosition = input[0];
        int dongsangPosition = input[1];
        bfs(subinPosition, dongsangPosition);
    }
    private static void bfs(int subinPosition, int dongsangPosition) {
        int[] visited = new int[100000];
        visited[subinPosition] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(subinPosition);
        while (!queue.isEmpty()) {
            Integer currentPosition = queue.poll();
            if (currentPosition == dongsangPosition) {
                break;
            }
            List<Integer> subinNextPositions = getSubinNextPositions(currentPosition);
            for (Integer subinNextPosition : subinNextPositions) {
                if (visited[subinNextPosition] == 0 && subinNextPosition<= 100000 && subinNextPosition>=0) {
                    visited[subinNextPosition] = visited[currentPosition] + 1;
                    queue.add(subinNextPosition);
                }
            }
        }
        System.out.println(visited[dongsangPosition]);
    }
    private static List<Integer> getSubinNextPositions (int currentPosition) {
        List<Integer> nextPositions = new ArrayList<>();
        nextPositions.add(currentPosition-1);
        nextPositions.add(currentPosition+1);
        nextPositions.add(currentPosition*2);
        return nextPositions;
    }
}
