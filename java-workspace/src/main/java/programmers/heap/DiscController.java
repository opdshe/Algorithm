package programmers.heap;

import java.util.*;

public class DiscController {
    private static int time = 0;

    public static void main(String[] args) {
        solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparing((a) -> a[0]));
        int currIdx = 0;
        int count =jobs.length;
        int sum = 0;
        int start = jobs[0][0];
        int end = start + Arrays.stream(jobs)
                .map(a -> a[1])
                .reduce(0, Integer::sum);
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b)->a[1] > b[1]?1:-1);
        while (time <= end) {
            try {
                for(int i = currIdx; i < count; i++ ){
                    if(jobs[i][0] <= time) {
                        queue.add(jobs[i]);
                        currIdx++;
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }

            if (!queue.isEmpty()) {
                int[] node = queue.poll();
                System.out.println(Arrays.toString(node));
                System.out.println("current time = " + time);
                time += node[1];
                sum += (time - node[0]);
                continue;
            }
            time++;
        }

        int answer = sum / count;
        System.out.println(answer);
        return answer;
    }
}