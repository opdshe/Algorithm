package 카카오.카카오2020하반기;

import java.util.Arrays;
import java.util.Comparator;


public class 오번 {
	public static void main(String[] args) {
		solution("02:03:55", "00:14:15",
				new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		return search(play_time, adv_time, logs);
	}

	private static String search(String play_time, String adv_time, String[] logs) {

		Log[] playLog = Arrays.stream(logs)
				.map((String s) -> convertToLog(s))
				.sorted(Comparator.comparing((Log l) -> l.end))
				.toArray(size -> new Log[logs.length]);
		int maxTime = convertToSecond(play_time);
		int advTime = convertToSecond(adv_time);
		int size = logs.length;
		int currentIdx = 0;
		int maxCountOfTime = 0;
		int minIdx = 0;
		int[] answer = new int[]{-1, -1};
		if (maxTime == advTime) {
			return convertToTime(0);
		}

		while (currentIdx < size) {
			int endTime = playLog[currentIdx].start + advTime;
			int countOfTime = 0;

			for (int i = currentIdx; i < size; i++) {
				int thisStartTime = playLog[i].start;
				int thisEndTime = playLog[i].end;
				if (thisStartTime < endTime) {
					if (thisEndTime > endTime) {
						countOfTime += endTime - thisStartTime;
					} else {
						countOfTime += thisEndTime - thisStartTime;
					}
				} else {
					break;
				}
			}
			if (countOfTime > maxCountOfTime) {
				answer = new int[]{playLog[currentIdx].start, endTime};
				System.out.println(convertToTime(answer[0]) + " " + convertToTime(endTime) + " " + convertToTime(countOfTime));
				maxCountOfTime = countOfTime;
			}
			currentIdx++;
		}
		System.out.println(convertToTime(answer[0]));
		return convertToTime(answer[0]);
	}

	private static Log convertToLog(String time) {
		String[] split = time.split("-");
		return new Log(convertToSecond(split[0]), convertToSecond(split[1]));
	}

	private static String convertToTime(int second) {
		int h = second / 3600;
		second = second % 3600;
		int m = second / 60;
		second = second % 60;
		int s = second;
		return String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);
	}

	private static int convertToSecond(String time) {
		int second = 0;
		String[] split = time.split(":");
		second += Integer.parseInt(split[0]) * 3600;
		second += Integer.parseInt(split[1]) * 60;
		second += Integer.parseInt(split[2]);
		return second;
	}

	private static class Log {
		private int start;
		private int end;

		public Log(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}