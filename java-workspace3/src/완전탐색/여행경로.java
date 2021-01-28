package 완전탐색;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 여행경로 {
	static List<List<String>> answers = new ArrayList<>();

	public static void main(String[] args) {
		solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
	}

	public static String[] solution(String[][] tickets) {
		boolean[] visited = new boolean[tickets.length];
		List<String> route = new ArrayList<>();
		route.add("ICN");
		dfs(tickets, route, visited, "ICN");
		answers.sort(Comparator.comparing((List<String> answer) -> String.join("", answer)));
		return answers.get(0).stream()
				.toArray(String[]::new);
	}

	private static void dfs(String[][] tickets, List<String> route, boolean[] visited, String current) {
		if (route.size() == tickets.length + 1) {
			answers.add(route);
			return;
		}
		for (int idx = 0; idx < tickets.length; idx++) {
			String[] ticket = tickets[idx];
			if (!visited[idx] && ticket[0].equals(current)) {
				visited[idx] = true;
				List<String> newRoute = new ArrayList<>(route);
				newRoute.add(ticket[1]);
				dfs(tickets, newRoute, visited, ticket[1]);
				visited[idx] = false;
			}
		}
	}
}
