package 프로그래머스.스택큐;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	public static void main(String[] args) {
		solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Job> jobQueue = new ArrayDeque<>();
		for (int idx = 0; idx < progresses.length; idx++) {
			jobQueue.add(new Job(progresses[idx], speeds[idx]));
		}
		return operate(jobQueue);
	}

	private static int[] operate(Queue<Job> jobQueue) {
		List<Integer> answer = new ArrayList<>();
		while (!jobQueue.isEmpty()) {
			for (Job job : jobQueue) {
				job.work();
			}
			if (jobQueue.peek().progress >= 100) {
				int count = 0;
				while (jobQueue.size() > 0) {
					if (jobQueue.peek().progress >= 100) {
						jobQueue.poll();
						count++;
					} else {
						break;
					}
				}
				answer.add(count);
			}
		}
		return answer.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}

	private static class Job {
		private int progress;
		private int rate;

		public Job(int progress, int rate) {
			this.progress = progress;
			this.rate = rate;
		}

		private void work() {
			progress += rate;
		}
	}
}