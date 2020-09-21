package 이분탐색;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 먹을것인가먹힐것인가 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int sizeOfA = scanner.nextInt();
			int sizeOfB = scanner.nextInt();
			int[] A = new int[sizeOfA];
			int[] B = new int[sizeOfB];
			for (int a = 0; a < sizeOfA; a++) {
				A[a] = scanner.nextInt();
			}
			for (int b = 0; b < sizeOfB; b++) {
				B[b] = scanner.nextInt();
			}
			solution(A, B);
		}
	}

	private static int solution(int[] A, int[] B) {
		List<Integer> AList = new ArrayList<>();
		for (int i : A) {
			AList.add(i);
		}
		List<Integer> BList = new ArrayList<>();
		for (int i : B) {
			BList.add(i);
		}
		AList.sort(Comparator.reverseOrder());
		BList.sort(Comparator.reverseOrder());

		int count = 0;
		for (int a = 0; a < AList.size(); a++) {
			for (int b = 0; b < BList.size(); b++) {
				if (AList.get(a) <= BList.get(b)) {
					continue;
				}
				count += (BList.size() - b);
				break;
			}
		}
		System.out.println(count);
		return count;
	}
}
