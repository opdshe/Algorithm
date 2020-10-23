package 분류안함;

import java.util.*;

public class 디스크컨트롤러 {

	public static void main(String[] args) {
		solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
	}

	public static int solution(int[][] jobs) {
		Arrays.sort(jobs, Comparator.comparing(ints -> ints[0]));
		Queue<Job> jobQueue = new PriorityQueue<>(Comparator.comparing(job -> job.burst));
		List<Job> terminatedJobs = new ArrayList<>();
		int nextTime = jobs[0][0];
		int nextIdx = 0;
		int pass = 0;
		while (pass < jobs.length) {
			//들어온 잡 추가
			for (int idx = nextIdx; idx < jobs.length; idx++) {
				if (jobs[idx][0] <= nextTime) {
					jobQueue.add(new Job(jobs[idx][0], jobs[idx][1]));
					nextIdx++;
				} else {
					break;
				}
			}
			//잡이 끝났으나 요청이 아직 안들어온 경우
			if (jobQueue.isEmpty()) {
				nextTime = jobs[nextIdx][0];
				continue;
			} else {
				Job job = jobQueue.poll();
				nextTime += job.burst;
				job.end(nextTime);
				terminatedJobs.add(job);
				pass++;
			}
		}
		int total = terminatedJobs.stream()
				.map(job -> job.end - job.come)
				.reduce(Integer::sum)
				.get();
		int answer = total / jobs.length;
		return answer;
	}

	private static class Job {
		private int come;
		private int burst;
		private int end;

		public Job(int come, int burst) {
			this.come = come;
			this.burst = burst;
		}

		private void end(int endTime) {
			this.end = endTime;
		}
	}
}