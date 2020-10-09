package LIS;

import java.util.*;

public class 반도체설계 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfLine = scanner.nextInt();
		scanner.nextLine();
		int[] lines = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		solution(lines);
	}

	private static void solution(int[] lines) {
		List<Integer> lineList = new ArrayList<>();
		for (int line : lines) {
			if (lineList.size() == 0) {
				lineList.add(line);
				continue;
			}
			if (line > lineList.get(lineList.size() - 1)) {
				lineList.add(line);
			} else {
				int idx = Collections.binarySearch(lineList, line);
				if (idx >= 0) {
					lineList.set(idx, line);
				} else {
					lineList.set(-idx - 1, line);
				}
			}
		}
		System.out.println(lineList.size());
	}
}
