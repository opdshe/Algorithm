package 그리디;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ATM {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		List<Integer> people = new ArrayList<>();
		for (int idx = 0; idx < countOfPeople; idx++) {
			people.add(scanner.nextInt());
		}
		people.sort(Comparator.naturalOrder());
		int currentTime = 0;
		int answer = 0;
		for (Integer person : people) {
			answer += currentTime + person;
			currentTime += person;
		}
		System.out.println(answer);
	}
}
