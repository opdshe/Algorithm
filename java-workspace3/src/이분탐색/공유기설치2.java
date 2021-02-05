package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치2 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] positions = new int[info[0]];
		for (int idx = 0; idx < info[0]; idx++) {
			positions[idx] = Integer.parseInt(bufferedReader.readLine());
		}
		Arrays.sort(positions);
		getMaxDistance(positions, info[0], info[1]);
	}

	private static int getMaxDistance(int[] positions, int countOfHouse, int countOfWifi) {
		int left = 1;
		int right = positions[countOfHouse - 1];
		int answer = 0;
		while (left <= right) {
			int minDistance = (left + right) / 2;
			int current = positions[0];
			int count = 1;
			for (int idx = 1; idx < countOfHouse; idx++) {
				int distance = positions[idx] - current;
				if (distance >= minDistance) {
					current = positions[idx];
					count++;
				}
			}

			if (count < countOfWifi) {
				right = minDistance - 1;
			} else {
				answer = Math.max(answer, minDistance);
				left = minDistance + 1;
			}
		}
		System.out.println(answer);
		return answer;
	}
}
