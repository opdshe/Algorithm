package 구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 스타트와링크 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] board;
	static boolean[] picked;
	static int[] pickedPeople;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		size = scanner.nextInt();
		board = new int[size][size];
		picked = new boolean[size];
		pickedPeople = new int[size / 2];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				board[row][column] = scanner.nextInt();
			}
		}
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int countOfPick, int start) {
		if (countOfPick == size / 2) {
			List<Integer> unpickedPeopleList = IntStream.range(0, size).boxed().collect(Collectors.toList());
			List<Integer> pickedPeopleList = new ArrayList<>();
			for (int pickedPerson : pickedPeople) {
				pickedPeopleList.add(pickedPerson);
				unpickedPeopleList.remove(Integer.valueOf(pickedPerson));
			}
			int diff = Math.abs(getSum(unpickedPeopleList) - getSum(pickedPeopleList));
			answer = Math.min(answer, diff);
			return;
		}
		for (int idx = start; idx < size; idx++) {
			if (!picked[idx]) {
				picked[idx] = true;
				pickedPeople[countOfPick] = idx;
				dfs(countOfPick + 1, idx + 1);
				picked[idx] = false;
			}
		}
	}

	private static int getSum(List<Integer> people) {
		int sum = 0;
		for (int pivotIdx = 0; pivotIdx < size / 2; pivotIdx++) {
			for (int targetIdx = pivotIdx + 1; targetIdx < size / 2; targetIdx++) {
				int pivot = people.get(pivotIdx);
				int target = people.get(targetIdx);
				sum += board[pivot][target];
				sum += board[target][pivot];
			}
		}
		return sum;
	}
}
