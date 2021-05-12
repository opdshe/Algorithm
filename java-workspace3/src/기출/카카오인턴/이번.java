package 기출.카카오인턴;

import java.util.ArrayList;
import java.util.List;

public class 이번 {
	public static void main(String[] args) {
		solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
	}

	public static int[] solution(String[][] places) {
		List<Integer> answers = new ArrayList<>();
		for (String[] place : places) {
			boolean isOkay = true;
			for (int row = 0; row < 5; row++) {
				if (!isOkay) {
					break;
				}
				for (int column = 0; column < 5; column++) {
					if (place[row].charAt(column) == 'P') {
						if (!isOkay(place, row, column)) {
							isOkay = false;
							break;
						}
					}
				}
			}
			if (isOkay) {
				answers.add(1);
			} else {
				answers.add(0);
			}
		}
		return answers.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
	}

	private static boolean isOkay(String[] place, int row, int column) {
		for (int nextRow = row; nextRow <= row + 2; nextRow++) {
			for (int nextColumn = column; nextColumn <= column + 2; nextColumn++) {
				//제자리는 제외
				if (nextRow == row && nextColumn == column) {
					continue;
				}
				if (isAvailable(nextRow, nextColumn)) {
					int distance = getDistance(row, column, nextRow, nextColumn);
					if (distance == 1 && place[nextRow].charAt(nextColumn) == 'P') {
						return false;
					}
					if (distance == 2 && place[nextRow].charAt(nextColumn) == 'P') {
						if (row == nextRow && nextColumn == column + 2) {
							if (place[row].charAt(column + 1) != 'X') {
								return false;
							}
						}
						if (row + 2 == nextRow && nextColumn == column) {
							if (place[row + 1].charAt(nextColumn) != 'X') {
								return false;
							}
						} else {
							if (row + 1 == nextRow && column + 1 == nextColumn) {
								if (!(place[row].charAt(column + 1) == 'X' && place[row + 1].charAt(column) == 'X')) {
									return false;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	private static int getDistance(int row, int column, int nextRow, int nextColumn) {
		return Math.abs(nextRow - row) + Math.abs(nextColumn - column);
	}

	private static boolean isAvailable(int row, int column) {
		return row >= 0 && row < 5 &&
				column >= 0 && column < 5;
	}
}
