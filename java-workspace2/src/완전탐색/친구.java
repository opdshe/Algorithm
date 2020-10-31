package 완전탐색;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 친구 {
	static Scanner scanner = new Scanner(System.in);
	static int[][] connections;

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		connections = new int[countOfPeople][countOfPeople];
		scanner.nextLine();
		for (int row = 0; row < countOfPeople; row++) {
			String connection = scanner.nextLine();
			for (int column = 0; column < countOfPeople; column++) {
				if (connection.charAt(column) == 'N') {
					connections[row][column] = 0;
				} else {
					connections[row][column] = 1;
				}
			}
		}
		solution(countOfPeople);
	}

	private static void solution(int countOfPeople) {
		Set<Integer>[] friends = new HashSet[countOfPeople];
		for (int idx = 0; idx < countOfPeople; idx++) {
			friends[idx] = new HashSet<>();
			for (int column = 0; column < countOfPeople; column++) {
				//친구이면
				if (connections[idx][column] == 1) {
					friends[idx].add(column);
					for (int ff = 0; ff < countOfPeople; ff++) {
						if (ff != idx && connections[column][ff] == 1) {
							friends[idx].add(ff);
						}
					}
				}
			}
		}
		int max = 0;
		for (Set<Integer> friend : friends) {
			max = Math.max(max, friend.size());
		}
		System.out.println(max);
	}
}
