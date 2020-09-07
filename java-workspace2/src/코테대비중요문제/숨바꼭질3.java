package 코테대비중요문제;

import java.util.*;

public class 숨바꼭질3 {
	static Scanner scanner = new Scanner(System.in);
	static int subin;
	static int sister;
	static int[] distance = new int[100001];
	static int answer = -1;

	public static void main(String[] args) {
		subin = scanner.nextInt();
		sister = scanner.nextInt();
		search();
		Arrays.fill(distance, -1);
		System.out.println(answer);
	}

	private static void search() {
		Queue<Position> queue = new PriorityQueue<>(Comparator.comparing((Position p) -> p.time));
		distance[subin] = 0;
		queue.add(new Position(subin, 0));

		while (!queue.isEmpty()) {
			Position current = queue.poll();
			if (current.position == sister) {
				answer = distance[current.position];
				break;
			}
			List<Integer> candidatePosition = getCandidatePosition(current.position);
			for (Integer nextPosition : candidatePosition) {
				if (isAvailablePosition(nextPosition)) {
					if (nextPosition == current.position * 2) {
						if (distance[nextPosition] == -1) {
							distance[nextPosition] = distance[current.position];
							queue.add(new Position(nextPosition, distance[nextPosition]));
						}
					} else {
						if (distance[nextPosition] == -1) {
							distance[nextPosition] = distance[current.position] + 1;
							queue.add(new Position(nextPosition, distance[nextPosition]));
						}
					}
				}
			}
		}
	}

	private static List<Integer> getCandidatePosition(int currentPosition) {
		List<Integer> candidates = new ArrayList<>();
		if (currentPosition != 0) {
			candidates.add(currentPosition * 2);
		}
		candidates.add(currentPosition + 1);
		candidates.add(currentPosition - 1);
		return candidates;
	}

	private static boolean isAvailablePosition(int position) {
		return position >= 0 && position <= 100000;
	}

	private static class Position {
		int position;
		int time;

		public Position(int position, int time) {
			this.position = position;
			this.time = time;
		}
	}
}
