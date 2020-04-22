package programmers.heap;


import java.util.Collections;
import java.util.PriorityQueue;

public class NoodleFactory {
    public static void main(String[] args) {
        Solution.solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30);
    }
}
class Solution {
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int currIdx = 0;
        int count = 0;
        while (stock < k) {
            for (int i =currIdx; i < dates.length; i++) {
                if (dates[i] <= stock){
                    priorityQueue.add(supplies[i]);
                    currIdx = i + 1;
                } else {
                    break;
                }
            }
            stock += priorityQueue.poll();
            count += 1;
        }
        System.out.println(count);
        return count;
    }
}