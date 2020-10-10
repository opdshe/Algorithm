package 기출.카카오.카카오2019인턴;


import java.util.*;

public class 불량사용자 {
	static Set<List<Integer>> set = new HashSet<>();
	static boolean[] visited;
	static int[] idx;

	public static void main(String[] args) {
		solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
				new String[]{"fr*d*", "*rodo", "******", "******"});
	}

	public static int solution(String[] user_id, String[] banned_id) {
		idx = new int[banned_id.length];
		visited = new boolean[user_id.length];
		dfs(user_id, banned_id, 0);
		System.out.println(set.size());
		return set.size();
	}

	private static void dfs(String[] user_id, String[] banned_id, int level) {
		if (level == banned_id.length) {
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < banned_id.length; i++) {
				result.add(idx[i]);
			}
			result.sort(Comparator.naturalOrder());
			set.add(result);
			return;
		}
		for (int i = 0; i < user_id.length; i++) {
			if (isAvailableId(user_id[i], banned_id[level])) {
				if (!visited[i]) {
					visited[i] = true;
					idx[level] = i;
					dfs(user_id, banned_id, level + 1);
					visited[i] = false;
				}
			}
		}
	}

	private static boolean isAvailableId(String user_id, String banned_id) {
		if (user_id.length() != banned_id.length()) {
			return false;
		}
		for (int idx = 0; idx < banned_id.length(); idx++) {
			if (banned_id.charAt(idx) == '*') {
				continue;
			}
			if (banned_id.charAt(idx) != user_id.charAt(idx)) {
				return false;
			}
		}
		return true;
	}
}