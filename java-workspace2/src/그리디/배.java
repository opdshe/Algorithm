package 그리디;

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
		int countOfCrane = Integer.parseInt(bufferedReader.readLine());
		List<Integer> efficiencyOfCrane = new ArrayList<>();
		int[] cranes = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int idx = 0; idx < countOfCrane; idx++) {
			efficiencyOfCrane.add(cranes[idx]);
		}
		int countOfBox = Integer.parseInt(bufferedReader.readLine());
		List<Integer> weightOfBox = new ArrayList<>();
		int[] boxes = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int idx = 0; idx < countOfBox; idx++) {
			weightOfBox.add(boxes[idx]);
		}

		efficiencyOfCrane.sort(Comparator.reverseOrder());
		weightOfBox.sort(Comparator.reverseOrder());
		solution(efficiencyOfCrane, weightOfBox, countOfCrane, countOfBox);
	}

	private static void solution(List<Integer> efficiencyOfCrane, List<Integer> weightOfBox, int countOfCrane, int countOfBox) {
		if (weightOfBox.get(0) > efficiencyOfCrane.get(0)) {
			System.out.println(-1);
			return;
		}
		int count = 0;
		int time = 0;
		while (count < countOfBox) {
			for (int craneIdx = 0; craneIdx < countOfCrane; craneIdx++) {
				Integer remove = null;
				for (Integer ofBox : weightOfBox) {
					if (efficiencyOfCrane.get(craneIdx) >= ofBox) {
						remove = ofBox;
						break;
					}
				}
				if (remove != null) {
					weightOfBox.remove(remove);
					count++;
				}
			}
			time++;
		}
		System.out.println(time);
	}
}
