package 프로그래머스.힙;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		solution(new int[][]{{0, 3}, {1, 9}, {2, 6}, {30, 3}});

	}

	public static int solution(int[][] jobs) {
		Arrays.sort(jobs, Comparator.comparing((int[] i) -> i[0]));
		search(jobs);
		return search(jobs);
	}

	private static int search(int[][] jobs) {
		int total = 0;
		Queue<Job> jobQueue = new PriorityQueue<>(Comparator.comparing((Job j) -> j.quantity));
		int currentTime = jobs[0][0];
		int currentIdx = 0;
		int maxTime = Arrays.stream(jobs)
				.map(ints -> ints[1])
				.reduce(0, Integer::sum);
		int count = 0;
		while (count < jobs.length) {
			for (int i = currentIdx; i < jobs.length; i++) {
				if (jobs[i][0] <= currentTime) {
					jobQueue.add(new Job(jobs[i][0], jobs[i][1]));
					currentIdx++;
				} else {
					break;
				}
			}
			if (!jobQueue.isEmpty()) {
				Job current = jobQueue.poll();
				currentTime += current.quantity;
				total += (currentTime - current.start);
				count++;
			} else {
				currentTime = jobs[currentIdx][0];
			}

		}
		return (total / jobs.length);
	}

	private static class Job {
		private int start;
		private int quantity;

		public Job(int start, int quantity) {
			this.start = start;
			this.quantity = quantity;
		}
	}
}
