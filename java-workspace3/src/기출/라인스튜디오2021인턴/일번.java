package 기출.라인스튜디오2021인턴;

import java.time.LocalDate;
import java.util.*;

public class 일번 {
	static final int YEAR = 2021;
	static Set<LocalDate> holidaySet = new HashSet<>();
	static List<LocalDate> holidayList = new ArrayList<>();
	static Set<Integer> continuousHolidays = new HashSet<>();

	public static void main(String[] args) {
		solution(new String[]{"01/14", "01/15", "01/18", "01/22", "01/23", "01/29", "02/01", "02/03", "02/07"}, 1);
	}

	public static int solution(String[] holidays, int k) {
		for (String holiday : holidays) {
			String[] split = holiday.split("/");
			holidaySet.add(LocalDate.of(YEAR, Integer.parseInt(split[0]), Integer.parseInt(split[1])));
		}
		initWeekend();
		holidayList.addAll(holidaySet);
		holidayList.sort(Comparator.naturalOrder());

		LocalDate prev = holidayList.get(0);
		int count = 1;
		for (int idx = 1; idx < holidayList.size(); idx++) {
			LocalDate holiday = holidayList.get(idx);
			int gap = prev.until(holiday).getDays();
			if (gap == 1) {
				count++;
				prev = holiday;
			} else {
				continuousHolidays.add(count);
				prev = holiday;
				count = 1;
			}
		}

		List<Integer> answers = new ArrayList<>(continuousHolidays);
		answers.sort(Comparator.reverseOrder());
		System.out.println(Arrays.toString(answers.toArray()));
		int answer = answers.get(k - 1);
		System.out.println(answer);
		return answer;
	}

	private static void initWeekend() {
		LocalDate next = LocalDate.of(YEAR, 1, 2);
		while (next.getYear() < 2022) {
			holidaySet.add(next);
			next = next.plusDays(7);
		}
		next = LocalDate.of(YEAR, 1, 3);
		while (next.getYear() < 2022) {
			holidaySet.add(next);
			next = next.plusDays(7);
		}
	}
}
