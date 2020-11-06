package 구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 요세푸스문제 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<Integer> people = new ArrayList<>();
		int countOfPeople = scanner.nextInt();
		int K = scanner.nextInt();
		for (int idx = 1; idx <= countOfPeople; idx++) {
			people.add(idx);
		}
		List<String> answer = new ArrayList<>();
		int currentIdx = 0;
		while (!people.isEmpty()) {
			int nextIdx = (currentIdx + (K - 1)) % people.size();
			answer.add(String.valueOf(people.remove(nextIdx)));
			currentIdx = nextIdx;
		}

		String ans = String.join(", ", answer);
		System.out.println("<" + ans + ">");
	}
}
