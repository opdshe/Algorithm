package 그리디;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 회의실배정 {
	static Scanner scanner = new Scanner(System.in);
	static List<Meeting> meetings = new ArrayList<>();

	public static void main(String[] args) {
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			meetings.add(new Meeting(start, end));
		}
		meetings.sort(new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if (o1.end > o2.end) {
					return 1;
				} else if (o1.end == o2.end) {
					if (o1.start > o2.start) {
						return 1;
					}
				}
				return -1;
			}
		});

		int endTime = -1;
		int count = 0;
		for (Meeting meeting : meetings) {
			if (meeting.start >= endTime) {
				count++;
				endTime = meeting.end;
			}
		}
		System.out.println(count);
	}

	private static class Meeting {
		private int start;
		private int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
