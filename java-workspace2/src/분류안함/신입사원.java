package 분류안함;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 신입사원 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(bufferedReader.readLine());
		for (int test = 0; test < testcase; test++) {
			int countOfCandidate = Integer.parseInt(bufferedReader.readLine());
			int[][] candidates = new int[countOfCandidate][2];
			for (int idx = 0; idx < countOfCandidate; idx++) {
				candidates[idx] = Arrays.stream(bufferedReader.readLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();
			}
			if (countOfCandidate == 1) {
				System.out.println(1);
				continue;
			}
			Arrays.sort(candidates, Comparator.comparing(candidate -> candidate[0]));
			int fail = 0;
			int minValue = candidates[0][1];
			for (int idx = 1; idx < countOfCandidate; idx++) {
				if (candidates[idx][1] > minValue) {
					fail++;
				} else {
					minValue = candidates[idx][1];
				}
			}
			System.out.println(countOfCandidate - fail);
		}
	}
}
