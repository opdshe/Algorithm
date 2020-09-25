package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 내려가기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] stairs;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(bufferedReader.readLine());
		stairs = new int[N + 1][3];
		int[][] maxDp = new int[N + 1][3];
		int[][] minDp = new int[N + 1][3];
		for (int height = 1; height <= N; height++) {
			stairs[height] = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		for (int height = 1; height <= N; height++) {
			maxDp[height][0] = Math.max(maxDp[height - 1][0], maxDp[height - 1][1]) + stairs[height][0];
			maxDp[height][1] = Math.max(Math.max(maxDp[height - 1][0], maxDp[height - 1][1]), maxDp[height - 1][2]) + stairs[height][1];
			maxDp[height][2] = Math.max(maxDp[height - 1][2], maxDp[height - 1][1]) + stairs[height][2];

			minDp[height][0] = Math.min(minDp[height - 1][0], minDp[height - 1][1]) + stairs[height][0];
			minDp[height][1] = Math.min(Math.min(minDp[height - 1][0], minDp[height - 1][1]), minDp[height - 1][2]) + stairs[height][1];
			minDp[height][2] = Math.min(minDp[height - 1][2], minDp[height - 1][1]) + stairs[height][2];
		}

		int maxValue = 0;
		for (int column = 0; column < 3; column++) {
			maxValue = Math.max(maxValue, maxDp[N][column]);
		}

		int minValue = 9 * N;
		for (int column = 0; column < 3; column++) {
			minValue = Math.min(minValue, minDp[N][column]);
		}
		System.out.print(maxValue + " " + minValue);
	}
}
