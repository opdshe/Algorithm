package 백준.골드;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 거짓말 {
	static Scanner scanner = new Scanner(System.in);
	static int[] truthMans;
	static int[] parents;

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		int countOfParty = scanner.nextInt();
		int countOfTruthMan = scanner.nextInt();
		List<List<Integer>> partyMembers = new ArrayList<>();
		truthMans = new int[countOfTruthMan];
		parents = new int[countOfPeople + 1];
		for (int idx = 1; idx <= countOfPeople; idx++) {
			parents[idx] = idx;
		}
		for (int idx = 0; idx < countOfTruthMan; idx++) {
			truthMans[idx] = scanner.nextInt();
		}
		for (int idx = 0; idx < countOfParty; idx++) {
			partyMembers.add(new ArrayList<>());
			int countOfMember = scanner.nextInt();
			int pivot = scanner.nextInt();
			partyMembers.get(idx).add(pivot);
			for (int i = 0; i < countOfMember - 1; i++) {
				int target = scanner.nextInt();
				partyMembers.get(idx).add(target);
				union(pivot, target);
			}
		}

		//파티 갈 수 있는지 확인
		int count = 0;
		for (List<Integer> partyMember : partyMembers) {
			boolean hasSameParent = false;
			for (Integer member : partyMember) {
				for (int truthMan : truthMans) {
					if (find(member) == find(truthMan)) {
						hasSameParent = true;
						break;
					}
				}
			}
			if (!hasSameParent) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static void union(int a, int b) {
		int parentOfA = find(a);
		int parentOfB = find(b);
		if (parentOfA < parentOfB) {
			parents[parentOfB] = parentOfA;
		} else {
			parents[parentOfA] = parentOfB;
		}
	}

	private static int find(int target) {
		if (target != parents[target]) {
			return find(parents[target]);
		}
		return parents[target];
	}
}
