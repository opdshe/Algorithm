package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        int count = 0;
        try {
            while (queue.peek() < K) {
                count++;
                mix(queue);
            }
        } catch (Exception e) {
            return -1;
        }
        return count;
    }

    private static void mix(Queue<Integer> queue) {
        int first = queue.poll();
        int second = queue.poll();
        int newFood = first + (second * 2);
        queue.add(newFood);
    }
}
