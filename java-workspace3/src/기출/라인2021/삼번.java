package 기출.라인2021;

import java.util.ArrayList;
import java.util.List;

public class 삼번 {
	private static List<Person> people = new ArrayList<>();

	public static void main(String[] args) {
		solution(new int[]{1, 3, 2}, new int[]{1, 2, 3});
	}

	public static int[] solution(int[] enter, int[] leave) {
		initPeople(enter);
		List<Integer> answers = new ArrayList<>();
		for (int idx = 0; idx < enter.length; idx++) {
			int order = idx + 1;
			people.get(enter[idx]).entrance = order;
			people.get(leave[idx]).leave = order;
		}
		for (Person pivot : people) {
			int count = 0;
			for (Person compare : people) {
				if (pivot == compare) {
					continue;
				}
				if ((pivot.entrance < compare.entrance && pivot.leave > compare.leave) ||
						(pivot.entrance > compare.entrance && pivot.leave < compare.leave)) {
					count++;
				}
			}
			answers.add(count);
		}
		return answers.stream()
				.mapToInt(Integer::valueOf)
				.skip(1)
				.toArray();
	}

	private static void initPeople(int[] enter) {
		for (int idx = 0; idx <= enter.length; idx++) {
			people.add(new Person());
		}
	}

	private static class Person {
		int entrance;
		int leave;
	}
}
