package 코테대비중요문제;

import java.util.*;

public class 산만한고양이 {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int M;
	static Map<Integer, Set<Integer>> map = new HashMap<>();

	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		for (int i = 0; i < M; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			Set<Integer> destMap = map.getOrDefault(dest, new HashSet<>());
			destMap.add(source);
			map.put(dest, destMap);
			Set<Integer> sourceMap = map.getOrDefault(source, new HashSet<>());
			sourceMap.add(dest);
			map.put(source, sourceMap);
		}
		System.out.println(Arrays.toString(map.get(2).toArray()));
	}
}
