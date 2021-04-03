package 기출.카카오커머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 일번 {
	private static Map<Integer, List<Person>> hashMap = new HashMap();
	private static List<Person> people = new ArrayList<>();

	public static void main(String[] args) {
		solution(new int[]{4, 5, 3, 2, 1}, new int[]{2, 4, 4, 5, 1});
	}

	public static int solution(int[] gift_cards, int[] wants) {
		for (int idx = 0; idx < gift_cards.length; idx++) {
			Person person = new Person(idx, gift_cards[idx], wants[idx], wants[idx] == gift_cards[idx]);
			List<Person> hasList = hashMap.getOrDefault(person.has, new ArrayList<>());
			hasList.add(person);
			hashMap.put(person.has, hasList);
			people.add(person);
		}

		for (Person person : people) {
			if (!person.fix) {
				int want = person.want;
				Person hasPerson = null;
				List<Person> hasList = hashMap.getOrDefault(want, new ArrayList<>());
				for (Person person1 : hasList) {
					if (!person1.fix) {
						hasPerson = person1;
						break;
					}
				}
				if (hasPerson != null) {
					change(person, hasPerson);
					person.fix = true;
					if (hasPerson.has == hasPerson.want) {
						hasPerson.fix = true;
					}
					hasList.remove(hasPerson);
					hashMap.put(want, hasList);
				}
			}
		}
		int answer = 0;
		for (Person person : people) {
			if (!person.fix) {
				answer++;
			}
		}
		return answer;
	}

	private static void change(Person a, Person b) {
		int temp_has = a.has;
		a.has = b.has;
		b.has = temp_has;
	}

	private static class Person {
		int idx;
		int has;
		int want;
		boolean fix;

		public Person(int idx, int has, int want, boolean fix) {
			this.idx = idx;
			this.has = has;
			this.want = want;
			this.fix = fix;
		}
	}
}
