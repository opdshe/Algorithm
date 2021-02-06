package 그리디;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 회의실배정 {
	static Scanner scanner = new Scanner(System.in);
	static List<Meeting> meetings = new ArrayList<>();

	public static void main(String[] args) {
		int countOfMeeting = scanner.nextInt();
		for (int i = 0; i < countOfMeeting; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			meetings.add(new Meeting(start, end));
		}
		meetings.sort((a, b) -> {
			if (a.end > b.end) {
				return 1;
			} else if (a.end == b.end) {
				if (a.start > b.start) {
					return 1;
				}
			}
			return -1;
		});
		solution(countOfMeeting);
	}

	private static void solution(int countOfMeeting) {
		int current = 0;
		int count = 0;
		for (Meeting meeting : meetings) {
			if (meeting.start >= current) {
				count++;
				current = meeting.end;
			}
		}
		System.out.println(count);
	}

	private static class Meeting {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Meeting{" +
					"start=" + start +
					", end=" + end +
					'}';
		}
	}
}
