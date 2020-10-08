package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 회의실배정 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfOrder = Integer.parseInt(bufferedReader.readLine());
		List<Meeting> meetings = new ArrayList<>();
		for (int idx = 0; idx < countOfOrder; idx++) {
			int[] order = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			meetings.add(new Meeting(order[0], order[1]));
		}
		meetings.sort((Meeting a, Meeting b) -> {
			if (a.end > b.end) {
				return 1;
			} else if (a.end == b.end) {
				if (a.start > b.start) {
					return 1;
				}
			}
			return -1;
		});
		solution(meetings);
	}

	private static void solution(List<Meeting> meetings) {
		int endTime = 0;
		int count = 0;
		for (Meeting meeting : meetings) {
			if (meeting.start >= endTime) {
				endTime = meeting.end;
				count++;
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
