package 기출.카카오커머스;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 삼번 {
	private static List<Integer>[] adjacent;
	private static int[] passenger;
	private static List<int[]> answerList = new ArrayList<>();
	private static int maxPassenger = 0;

	public static int[] solution(int n, int[] p, int[][] train) {
		passenger = new int[n + 1];
		for (int idx = 0; idx < n; idx++) {
			passenger[idx + 1] = p[idx];
		}
		init(n);
		for (int[] ints : train) {
			adjacent[ints[0]].add(ints[1]);
			adjacent[ints[1]].add(ints[0]);
		}
		int[] sumOfPassenger = new int[n + 1];
		setSumOfPassenger(sumOfPassenger, 1, 0);
		for (int idx = 1; idx <= n; idx++) {
			if (sumOfPassenger[idx] > maxPassenger) {
				maxPassenger = sumOfPassenger[idx];
				answerList = new ArrayList<>();
				answerList.add(new int[]{idx, sumOfPassenger[idx]});
			} else if (sumOfPassenger[idx] == maxPassenger) {
				answerList.add(new int[]{idx, sumOfPassenger[idx]});
			}
		}
		answerList.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] < o2[1]) {
					return 1;
				} else if (o1[1] == o2[1]) {
					if (o1[0] < o2[0]) {
						return 1;
					}
				}
				return -1;
			}
		});
		return answerList.get(0);
	}

	private static void init(int n) {
		adjacent = new ArrayList[n + 1];
		for (int idx = 0; idx <= n; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
	}

	private static void setSumOfPassenger(int[] sumOfPassenger, int current, int sum) {
		sumOfPassenger[current] = sum + passenger[current];
		for (Integer adj : adjacent[current]) {
			if (sumOfPassenger[adj] == 0) {
				setSumOfPassenger(sumOfPassenger, adj, sumOfPassenger[current]);
			}
		}
	}
}
