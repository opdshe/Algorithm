package 그래프.최단경로.위상정렬;

import java.util.*;

public class 줄세우기 {
	static Scanner scanner = new Scanner(System.in);
	static List<Integer>[] orders;
	static int[] inDegree;

	public static void main(String[] args) {
		int countOfStudent = scanner.nextInt();
		int countOfInfo = scanner.nextInt();
		scanner.nextLine();
		orders = new ArrayList[countOfStudent + 1];
		inDegree = new int[countOfStudent + 1];
		for (int idx = 1; idx <= countOfStudent; idx++) {
			orders[idx] = new ArrayList<>();
		}
		for (int i = 0; i < countOfInfo; i++) {
			String[] info = scanner.nextLine().split(" ");
			orders[Integer.parseInt(info[0])].add(Integer.parseInt(info[1]));
			inDegree[Integer.parseInt(info[1])]++;
		}
		List<Integer> list = topologicalSort(countOfStudent);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}

	private static List<Integer> topologicalSort(int countOfStudent) {
		List<Integer> answers = new ArrayList<>();
		Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
		for (int idx = 1; idx <= countOfStudent; idx++) {
			if (inDegree[idx] == 0) {
				queue.add(idx);
			}
		}
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			answers.add(current);
			for (Integer adjacent : orders[current]) {
				inDegree[adjacent]--;
				if (inDegree[adjacent] == 0) {
					queue.add(adjacent);
				}
			}
		}
		return answers;
	}

}
