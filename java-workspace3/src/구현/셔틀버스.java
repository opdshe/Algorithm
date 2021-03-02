package 구현;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class 셔틀버스 {
	private static final LocalTime startTime = LocalTime.of(9, 0);
	private static List<Bus> buses = new ArrayList<>();
	private static Queue<Crew> crews = new PriorityQueue<>(Comparator.comparing(crew -> crew.arriveTime));
	private static String answer;

	public static void main(String[] args) {
		solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"});
	}

	public static String solution(int n, int t, int m, String[] timetable) {
		init(n, t, m, timetable);
		for (Bus bus : buses) {
			List<Crew> waiting = new ArrayList<>();
			for (int i = 0; i < bus.limit; i++) {
				if (!crews.isEmpty() && ((crews.peek().arriveTime.isBefore(bus.arriveTime)) ||
						crews.peek().arriveTime.equals(bus.arriveTime))) {
					waiting.add(crews.poll());
				}
			}
			if (waiting.size() < bus.limit) {
				answer = bus.arriveTime.format(DateTimeFormatter.ofPattern("HH:mm"));
			} else {
				answer = waiting.get(bus.limit - 1).arriveTime.minusMinutes(1).format(DateTimeFormatter.ofPattern("HH:mm"));
				;
			}
		}
		return answer;
	}

	private static void init(int n, int interval, int limit, String[] timetable) {
		for (int i = 0; i < n; i++) {
			buses.add(new Bus(startTime.plusMinutes(interval * i), limit));
		}

		for (String time : timetable) {
			String[] split = time.split(":");
			if (split[0].equals("24") && split[1].equals("00")) {
				crews.add(new Crew(LocalTime.of(Integer.parseInt("23"), Integer.parseInt("59"))));
			} else {
				crews.add(new Crew(LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]))));
			}
		}
	}

	private static class Bus {
		private LocalTime arriveTime;
		private int limit;

		public Bus(LocalTime arriveTime, int limit) {
			this.arriveTime = arriveTime;
			this.limit = limit;
		}
	}

	private static class Crew {
		private LocalTime arriveTime;

		public Crew(LocalTime arriveTime) {
			this.arriveTime = arriveTime;
		}
	}
}
