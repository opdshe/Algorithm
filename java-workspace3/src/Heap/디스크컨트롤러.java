package Heap;

import java.util.*;

public class 디스크컨트롤러 {
	public int solution(int[][] jobs) {
		int answer = getMinAverage(jobs);
		return answer;
	}

	private static int getMinAverage(int[][] jobs) {
		Queue<Job> jobQueue = new PriorityQueue<>(Comparator.comparing(job -> job.request));
		Queue<Job> readyQueue = new PriorityQueue<>(Comparator.comparing(job -> job.burst));
		List<Job> terminated = new ArrayList<>();
		int currentTime = 0;
		int pass = 0;
		for (int[] job : jobs) {
			jobQueue.add(new Job(job[0], job[1]));
		}
		while (pass < jobs.length) {
			while (!jobQueue.isEmpty() && jobQueue.peek().request <= currentTime) {
				readyQueue.add(jobQueue.poll());
			}
			if (readyQueue.isEmpty()) {
				currentTime = jobQueue.peek().request;
				while (!jobQueue.isEmpty() && jobQueue.peek().request <= currentTime) {
					readyQueue.add(jobQueue.poll());
				}
			}
			Job job = readyQueue.poll();
			job.end(currentTime);
			terminated.add(job);

			currentTime = job.end;
			pass++;
		}
		Integer sum = terminated.stream()
				.map(job -> job.end - job.request)
				.reduce(Integer::sum)
				.get();
		return sum / jobs.length;
	}

	private static class Job {
		int request;
		int burst;
		int end;

		public Job(int request, int burst) {
			this.request = request;
			this.burst = burst;
		}

		private void end(int start) {
			end = start + burst;
		}
	}
}
