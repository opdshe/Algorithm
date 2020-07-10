package 프로그래머스;

import java.util.*;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        solution(2, 10, new int[]{7, 4, 5, 6});
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waiting = new ArrayDeque<>();
        Queue<Truck> onBridge = new ArrayDeque<>();
        List<Integer> passed = new ArrayList<>();
        Arrays.stream(truck_weights).forEach(waiting::add);
        int time = 0;
        int currentWeight = 0;

        while (passed.size()< truck_weights.length) {
            for(Truck truck : onBridge){
                currentWeight -= truck.go(passed, onBridge);
            }
            while (!waiting.isEmpty()) {
                if (waiting.peek() + currentWeight <= weight) {
                    onBridge.add(new Truck(waiting.peek(), bridge_length));
                    System.out.println("add : " + waiting.peek());
                    System.out.println("time : " + time);
                    currentWeight += waiting.poll();
                }
                break;
            }
            time++;
            System.out.println(Arrays.toString(passed.toArray()));
        }
        System.out.println(time);

        return time;
    }

    static class Truck {
        private int weight;
        private int restLength;

        public Truck(int weight, int restLength) {
            this.weight = weight;
            this.restLength = restLength;
        }

        private int go(List<Integer> passed, Queue<Truck> onBridge) {
            this.restLength--;
            if (this.restLength == 0) {
                passed.add(this.weight);
                onBridge.remove(this);
                return this.weight;
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Truck truck = (Truck) o;
            return weight == truck.weight &&
                    restLength == truck.restLength;
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight, restLength);
        }
    }
}
