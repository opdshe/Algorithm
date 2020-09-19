package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신입사원 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testCase = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < testCase; i++) {
			int countOfPeople = Integer.parseInt(bufferedReader.readLine());
			int[] candidates = new int[countOfPeople + 1];
			for (int p = 0; p < countOfPeople; p++) {
				String[] input = bufferedReader.readLine().split(" ");
				int first = Integer.parseInt(input[0]);
				int second = Integer.parseInt(input[1]);
				candidates[first] = second;
			}
			int count = 0;
			for (int pivot = 2; pivot <= countOfPeople; pivot++) {
				for (int prev = 1; prev < pivot; prev++) {
					if (candidates[pivot] > candidates[prev]) {
						count++;
						break;
					}
				}
			}
			System.out.println(countOfPeople - count);
		}
	}
}
