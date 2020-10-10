package 기출.카카오.카카오2019;

import java.util.*;

public class 후보키 {
	static int countOfRow;
	static int countOfColumn;
	static List<Integer> candidates = new ArrayList<>();
	static boolean[] visited;
	static boolean[] array;

	public static void main(String[] args) {
		visited = new boolean[5];
		array = new boolean[5];
		solution(new String[][]{
				{"100", "ryan", "music", "2"},
				{"200", "apeach", "math", "2"},
				{"300", "tube", "computer", "3"},
				{"400", "con", "computer", "4"},
				{"500", "muzi", "music", "3"},
				{"600", "apeach", "music", "2"}
		});
	}

	public static int solution(String[][] relation) {
		countOfRow = relation.length;
		countOfColumn = relation[0].length;
		for (int i = 1; i < 1 << countOfColumn; i++) {
			if (check(relation, i)) {
				candidates.add(i);
			}
		}
		System.out.println(candidates.size());
		System.out.println(Arrays.toString(candidates.toArray()));
		return candidates.size();
	}

	private static boolean check(String[][] relation, int subset) {
		for (Integer candidate : candidates) {
			if ((candidate & subset) >= candidate) {
				return false;
			}
		}
		List<Integer> idx = new ArrayList<>();
		for (int i = 0; i < countOfColumn; i++) {
			if ((subset & (1 << i)) > 0) {
				idx.add(i);
			}
		}
		Set<String> set = new HashSet<>();
		for (int row = 0; row < countOfRow; row++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (Integer column : idx) {
				stringBuilder.append(relation[row][column]);
			}
			set.add(stringBuilder.toString());
		}
		return set.size() == countOfRow;
	}

}