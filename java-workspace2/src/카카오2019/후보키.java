package 카카오2019;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 후보키 {
	static int countOfRow;
	static int countOfColumn;
	static int[] columns;

	public static void main(String[] args) {
		Set<String[]> temp = new HashSet<>();
		temp.add(new String[]{"hi, hello"});
		temp.add(new String[]{"hi, hello"});
		System.out.println(Arrays.toString(temp.toArray()));
	}

	public static int solution(String[][] relation) {
		countOfRow = relation.length;
		countOfColumn = relation[0].length;

		columns = new int[countOfColumn];

		for (int i = 1; i <= countOfColumn; i++) {
			dfs(0, 1);
		}
		return 0;
	}

	private static void dfs(int level, int size) {
		for (int i = 0; i < countOfColumn; i++) {

		}
	}
}