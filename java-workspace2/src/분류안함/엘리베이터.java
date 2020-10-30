package 분류안함;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 엘리베이터 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int[][][] digits = new int[10][5][3];
	static int[] array;
	static List<Integer> answer = new ArrayList<>();

	private static void init() {
		digits[0] = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 0, 1}, {1, 0, 1}, {1, 1, 1}};
		digits[1] = new int[][]{{0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}};
		digits[2] = new int[][]{{1, 1, 1}, {0, 0, 1}, {1, 1, 1}, {1, 0, 0}, {1, 1, 1}};
		digits[3] = new int[][]{{1, 1, 1}, {0, 0, 1}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}};
		digits[4] = new int[][]{{1, 0, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {0, 0, 1}};
		digits[5] = new int[][]{{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}};
		digits[6] = new int[][]{{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
		digits[7] = new int[][]{{1, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}};
		digits[8] = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
		digits[9] = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}};
	}

	public static void main(String[] args) throws IOException {
		init();
		int countOfNumber = Integer.parseInt(bufferedReader.readLine());
		array = new int[countOfNumber];
		int[][] numbers = new int[5][4 * countOfNumber - 1];
		for (int row = 0; row < 5; row++) {
			String line = bufferedReader.readLine();
			for (int column = 0; column < 4 * countOfNumber - 1; column++) {
				if (line.charAt(column) == '#') {
					numbers[row][column] = 1;
				} else {
					numbers[row][column] = 0;
				}
			}
		}
		dfs(numbers, countOfNumber, 0);
		System.out.println(calculate());
	}

	private static double calculate() {
		if (answer.size() == 0) {
			return -1;
		}
		return answer.stream()
				.mapToInt(Integer::intValue)
				.average()
				.getAsDouble();
	}

	private static void dfs(int[][] numbers, int countOfNumber, int level) {
		if (level == countOfNumber) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int i : array) {
				stringBuilder.append(i);
			}
			answer.add(Integer.parseInt(stringBuilder.toString()));
			return;
		}
		int start = 4 * level;
		for (int idx = 0; idx < 10; idx++) {
			int[][] digit = digits[idx];
			boolean isOkay = true;
			for (int row = 0; row < 5; row++) {
				for (int column = start; column < start + 3; column++) {
					if (numbers[row][column] == 1 && digit[row][column - start] == 0) {
						isOkay = false;
						break;
					}
				}
			}
			if (isOkay) {
				array[level] = idx;
				dfs(numbers, countOfNumber, level + 1);
			}
		}
	}
}
