package 분류안함;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		solution(2, 10, new int[]{7, 4, 5, 6});
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> onRoad = new ArrayDeque<>();
		int time = 0;
		int idx = 0;
		int currentWeight = 0;
		int pass = 0;
		while (pass < truck_weights.length) {
			if (!onRoad.isEmpty()) {
				if (onRoad.peek().end == time) {
					Truck truck = onRoad.poll();
					currentWeight -= truck.weight;
					pass++;
				}
			}
			if (idx < truck_weights.length) {
				if (currentWeight + truck_weights[idx] <= weight) {
					onRoad.add(new Truck(truck_weights[idx], time + bridge_length));
					currentWeight += truck_weights[idx++];
				}
			}
			time++;
		}
		return time;
	}

	private static class Truck {
		private int weight;
		private int end;

		public Truck(int weight, int end) {
			this.weight = weight;
			this.end = end;
		}
	}
}