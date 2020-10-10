package 기출.쿠팡;

import java.util.*;

public class 사번 {
	static Map<String, List<String>> map = new HashMap<>();
	static int countOfPath = 0;

	public static void main(String[] args) {
		solution("SEOUL", "DAEGU", "YEOSU",
				new String[][]{
						{"ULSAN", "BUSAN"},
						{"DAEJEON", "ULSAN"},
						{"DAEJEON", "GWANGJU"},
						{"SEOUL", "DAEJEON"},
						{"SEOUL", "ULSAN"},
						{"DAEJEON", "DAEGU"},
						{"GWANGJU", "BUSAN"},
						{"DAEGU", "GWANGJU"},
						{"DAEGU", "BUSAN"},
						{"ULSAN", "DAEGU"},
						{"GWANGJU", "YEOSU"},
						{"BUSAN", "YEOSU"}
				});
	}

	private static int solution(String depar, String hub, String dest, String[][] roads) {
		for (String[] road : roads) {
			List<String> adjacent;
			if (map.containsKey(road[0])) {
				adjacent = map.get(road[0]);
			} else {
				adjacent = new ArrayList<>();
			}
			adjacent.add(road[1]);
			map.put(road[0], adjacent);
		}
		findPath(new HashSet<>(), depar, hub);
		int midPath = countOfPath % 10007;
		countOfPath = 0;
		findPath(new HashSet<>(), hub, dest);
		int finalPath = countOfPath % 10007;
		System.out.println((midPath * finalPath) % 10007);
		return (midPath * finalPath) % 10007;
	}

	private static void findPath(Set<String> visited, String source, String dest) {
		if (source.equals(dest)) {
			countOfPath++;
			return;
		}
		if (map.containsKey(source)) {
			for (String adjacent : map.get(source)) {
				if (!visited.contains(adjacent)) {
					visited.add(adjacent);
					findPath(visited, adjacent, dest);
					visited.remove(adjacent);
				}
			}
		}
	}
}
