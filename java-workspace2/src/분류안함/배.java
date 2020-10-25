package 분류안함;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 배 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfContainer = Integer.parseInt(bufferedReader.readLine());
		List<Integer> containers = new ArrayList<>();
		int[] containerInput = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int idx = 0; idx < countOfContainer; idx++) {
			containers.add(containerInput[idx]);
		}
		int countOfItem = Integer.parseInt(bufferedReader.readLine());
		List<Integer> items = new ArrayList<>();
		int[] itemInput = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		for (int idx = 0; idx < countOfItem; idx++) {
			items.add(itemInput[idx]);
		}
		containers.sort(Comparator.reverseOrder());
		items.sort(Comparator.reverseOrder());
		solution(containers, items);
	}

	private static void solution(List<Integer> containers, List<Integer> items) {
		if (containers.get(0) < items.get(0)) {
			System.out.println(-1);
			return;
		}
		int time = 0;
		while (items.size() > 0) {
			for (Integer container : containers) {
				Integer removeTarget = null;
				for (Integer item : items) {
					if (container >= item) {
						removeTarget = item;
						break;
					}
				}
				items.remove(removeTarget);
			}
			time++;
		}
		System.out.println(time);
	}
}
