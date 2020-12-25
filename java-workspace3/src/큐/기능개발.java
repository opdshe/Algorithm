package 큐;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Job> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        for (int idx = 0; idx < progresses.length; idx++) {
            queue.add(new Job(progresses[idx], speeds[idx]));
        }
        while (!queue.isEmpty()) {
            for (Job job : queue) {
                job.progress();
            }
            int count = 0;
            while (!queue.isEmpty() && queue.peek().isCompleted()) {
                queue.poll();
                count++;
            }
            if (count > 0) {
                answer.add(count);
            }
        }
        return answer.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static class Job {
        int progress;
        int speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        private void progress() {
            this.progress += speed;
        }

        private boolean isCompleted() {
            return progress >= 100;
        }
    }
}
