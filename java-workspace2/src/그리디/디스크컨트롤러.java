package 그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {

	public static void main(String[] args) {
		solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
	}

	public static int solution(int[][] jobs) {
		Arrays.sort(jobs, Comparator.comparing((int[] job) -> job[0]));
		int count = 0;
		int currentTime = jobs[0][0];
		int currentIdx = 0;
		int total = 0;
		Queue<Job> jobQueue = new PriorityQueue<>(Comparator.comparing(job -> job.time));
		while (count < jobs.length) {
			for (int idx = currentIdx; idx < jobs.length; idx++) {
				if (jobs[idx][0] <= currentTime) {
					jobQueue.add(new Job(jobs[idx][0], jobs[idx][1]));
					currentIdx++;
				} else {
					break;
				}
			}
			if (!jobQueue.isEmpty()) {
				Job current = jobQueue.poll();
				int endTime = currentTime + current.time;
				total += endTime - current.start;
				currentTime = endTime;
				count++;
			} else {
				currentTime = jobs[currentIdx][0];
			}
		}
		return total / jobs.length;
	}

	private static class Job {
		private int start;
		private int time;

		public Job(int start, int time) {
			this.start = start;
			this.time = time;
		}
	}
}