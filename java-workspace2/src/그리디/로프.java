package 그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 로프 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfRopes = scanner.nextInt();
		List<Integer> ropes = new ArrayList<>();
		for (int i = 0; i < countOfRopes; i++) {
			ropes.add(scanner.nextInt());
		}
		Collections.sort(ropes, Collections.reverseOrder());
		long availableWeight = 0;
		for (int i = 0; i < ropes.size(); i++) {
			if (availableWeight < (ropes.get(i) * (i + 1))) {
				availableWeight = ropes.get(i) * (i + 1);
			}
		}
		System.out.println(availableWeight);
	}
}
