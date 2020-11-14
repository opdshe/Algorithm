package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 배 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws IOException {
		int countOfCrane = Integer.parseInt(bufferedReader.readLine());
		List<Integer> cranes = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());
		int countOfContainer = Integer.parseInt(bufferedReader.readLine());
		List<Integer> containers = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());

		cranes.sort(Comparator.reverseOrder());
		containers.sort(Comparator.reverseOrder());

		System.out.println(solution(containers, cranes));
	}

	private static int solution(List<Integer> containers, List<Integer> cranes) {
		if (cranes.get(0) < containers.get(0)) {
			return -1;
		}
		int time = 0;
		while (!containers.isEmpty()) {
			time++;
			for (Integer crane : cranes) {
				Integer removeContainer = null;
				for (Integer container : containers) {
					if (crane >= container) {
						removeContainer = container;
						break;
					}
				}
				containers.remove(removeContainer);
			}
		}
		return time;
	}
}
