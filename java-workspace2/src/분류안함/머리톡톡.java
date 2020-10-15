package 분류안함;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 머리톡톡 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfPeople = Integer.parseInt(bufferedReader.readLine());
		List<Person> people = new ArrayList<>();
		for (int idx = 0; idx < countOfPeople; idx++) {
			people.add(new Person(idx, Integer.parseInt(bufferedReader.readLine()), 0));
		}
		people.sort(Comparator.comparing((person -> person.value)));
		for (int idx = 0; idx < countOfPeople; idx++) {
			for (int target = idx + 1; target < countOfPeople; target++) {
				Person targetPerson = people.get(target);
				if (targetPerson.value % people.get(idx).value == 0) {
					targetPerson.touch++;
					if (targetPerson.value == people.get(idx).value) {
						people.get(idx).touch++;
					}
				}
			}
		}
		people.sort(Comparator.comparing((person -> person.idx)));
		for (Person person : people) {
			System.out.println(person.touch);
		}
	}

	private static class Person {
		private int idx;
		private int value;
		private int touch;

		public Person(int idx, int value, int touch) {
			this.idx = idx;
			this.value = value;
			this.touch = touch;
		}
	}
}
