package 라인2020;

import java.util.ArrayList;
import java.util.List;

public class 이번 {
	static List<Ball> ballList = new ArrayList<>();
	static List<Integer> answer = new ArrayList<>();

	public static void main(String[] args) {
		solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 2, 5, 1, 4, 3});
	}

	public static int[] solution(int[] ball, int[] order) {
		for (int i : ball) {
			ballList.add(new Ball(i));
		}
		operate(order);
		return answer.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}

	private static void operate(int[] order) {
		for (int orderNumber : order) {
			while (ballList.get(0).ordered) {
				answer.add(ballList.get(0).idx);
				ballList.remove(0);
			}
			while (ballList.get(ballList.size() - 1).ordered) {
				answer.add(ballList.get(ballList.size() - 1).idx);
				ballList.remove(ballList.size() - 1);
			}
			if (ballList.get(0).idx == orderNumber) {
				answer.add(ballList.get(0).idx);
				ballList.remove(0);
			} else if (ballList.get(ballList.size() - 1).idx == orderNumber) {
				answer.add(ballList.get(ballList.size() - 1).idx);
				ballList.remove(ballList.get(ballList.size() - 1));
			} else {
				for (Ball ball : ballList) {
					if (ball.idx == orderNumber) {
						ball.ordered = true;
						break;
					}
				}
			}

		}
	}

	private static class Ball {
		private int idx;
		private boolean ordered;

		public Ball(int idx) {
			this.idx = idx;
		}
	}
}