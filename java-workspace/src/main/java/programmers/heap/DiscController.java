package programmers.heap;


import java.util.*;

public class DiscController {
    public static void main(String[] args) {
        solution(new int[][]{{0,3}, {1, 9}, {2, 6}});
        int [] myArray = new int[] {14,25, 1, 4,5};
        int [] newArray = Arrays.copyOfRange(myArray, 0, 3);
        System.out.println(Arrays.toString(newArray));
    }

    public static int solution(int[][] jobs) {
        int sumOfRunningTime = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new myCompartor());
        priorityQueue.addAll(Arrays.asList(jobs));
        int start = priorityQueue.peek()[0];
        while(!priorityQueue.isEmpty()) {
            int[] node = priorityQueue.poll();
            int end = start + node[1];
            int runningTime = end - node[0];
            sumOfRunningTime += runningTime;
            start = end;
        }
        System.out.println(sumOfRunningTime/jobs.length);
        return sumOfRunningTime/jobs.length;
    }
}
class myCompartor implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] < o2[0]) {
            return -1;
        }
        return 1;
    }
}