package programmers.stack_queue;

import java.util.*;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        solution(100, 100, new int[]{10});
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentWeight = 0;
        int pass = 0;
        int countOfCar = truck_weights.length;
        List<Integer> onRoad = new ArrayList<>();
        Queue<Integer> waitingQueue = new ArrayDeque<>();
        Arrays.stream(truck_weights).forEach(waitingQueue::add);
        while (pass< countOfCar) {
            for(int i = 0; i < onRoad.size(); i++) {
                onRoad.set(i, onRoad.get(i) -1);
            }
            if(!onRoad.isEmpty() && onRoad.get(0) == 0) {
                onRoad.remove(0);
                currentWeight -= truck_weights[pass];
                pass++;
            }
            if(!waitingQueue.isEmpty() && waitingQueue.peek() + currentWeight <= weight) {
                int carWeight = waitingQueue.poll();
                currentWeight += carWeight;
                onRoad.add(bridge_length);
            }
            time++;
        }
        System.out.println(time);
        return time;
    }
}
