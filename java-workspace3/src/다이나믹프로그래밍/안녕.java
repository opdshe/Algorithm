package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 안녕 {
	static Scanner scanner = new Scanner(System.in);
	static List<Person> people = new ArrayList<>();

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		int[] costs = new int[countOfPeople + 1];
		int[] pleasures = new int[countOfPeople + 1];
		int[][] dp = new int[countOfPeople + 1][100];
		for (int idx = 1; idx <= countOfPeople; idx++) {
			costs[idx] = scanner.nextInt();
		}
		for (int idx = 1; idx <= countOfPeople; idx++) {
			pleasures[idx] = scanner.nextInt();
		}
		for (int idx = 1; idx <= countOfPeople; idx++) {
			people.add(new Person(costs[idx], pleasures[idx]));
		}
		people.sort(Comparator.comparing(person -> person.cost));
		people.add(0, new Person(0, 0));

		for (int maxIdx = 1; maxIdx <= countOfPeople; maxIdx++) {
			for (int hp = 1; hp < 100; hp++) {
				Person person = people.get(maxIdx);
				if (hp >= person.cost) {
					dp[maxIdx][hp] = Math.max(dp[maxIdx - 1][person.cost],
							dp[maxIdx - 1][hp - person.cost] + person.pleasure);
				} else {
					dp[maxIdx][hp] = dp[maxIdx - 1][hp];
				}
			}
		}
		int answer = 0;
		for (int idx = 0; idx < 100; idx++) {
			answer = Math.max(answer, dp[countOfPeople][idx]);
		}
		System.out.println(answer);
	}

	private static class Person {
		int cost;
		int pleasure;

		public Person(int cost, int pleasure) {
			this.cost = cost;
			this.pleasure = pleasure;
		}
	}

}
