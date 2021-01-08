package 구현;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class 추석트래픽 {
    static List<Job> jobs = new ArrayList<>();
    static List<LocalTime> times = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) {
        solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"});
    }

    public static int solution(String[] lines) {
        for (String line : lines) {
            String[] split = line.split(" ");
            String[] end = split[1].split(":");
            long runningTime = getRunningTime(split[2]);
            LocalTime endTime = LocalTime.of(Integer.parseInt(end[0]), Integer.parseInt(end[1]),
                    Integer.parseInt(end[2].split("\\.")[0]),
                    Integer.parseInt(end[2].split("\\.")[1]) * 1000000);
            LocalTime startTime = endTime.minusNanos(runningTime).plusNanos(1000000);
            jobs.add(new Job(startTime, endTime));
            times.add(startTime);
            times.add(endTime);
        }
        for (LocalTime timeStart : times) {
            LocalTime timeEnd = timeStart.plusSeconds(1);
            timeEnd = timeEnd.minusNanos(1000000);
            int count = 0;
            for (Job job : jobs) {
                if (job.start.equals(timeStart) || job.end.equals(timeStart) ||
                        (job.start.isBefore(timeStart) && job.end.isAfter(timeStart))) {
                    count++;
                } else if (job.start.equals(timeEnd) || job.end.equals(timeEnd) ||
                        (job.start.isBefore(timeEnd) && job.end.isAfter(timeEnd))) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
        return answer;
    }

    private static long getRunningTime(String runningTime) {
        runningTime = runningTime.replaceAll("s", "");
        long nanos = 0;
        if (runningTime.contains(".")) {
            String[] split = runningTime.split("\\.");
            String milliSecond = split[1] + "0".repeat(3 - split[1].length());
            nanos += Long.parseLong(milliSecond) * 1000000;
            nanos += Long.parseLong(split[0]) * 1000000000;
        } else {
            nanos += Long.parseLong(runningTime) * 1000000000;
        }
        return nanos;
    }

    private static class Job {
        LocalTime start;
        LocalTime end;

        public Job(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }
    }
}
