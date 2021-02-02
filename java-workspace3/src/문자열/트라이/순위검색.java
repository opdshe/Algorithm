package 문자열.트라이;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 순위검색 {
	public static void main(String[] args) {
		solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
				new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});

	}

	public static int[] solution(String[] info, String[] query) {
		List<Integer> answers = new ArrayList<>();
		Trie trie = new Trie();
		for (String s : info) {
			String[] split = s.split(" ");
			trie.add(split);
		}
		for (String s : query) {
			s = s.replaceAll("and ", "");
			String[] split = s.split(" ");
			answers.add(trie.getCount(split));
		}
		return answers.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
	}

	private static class Trie {
		Node root = new Node();

		private void add(String[] info) {
			Node node = root;
			for (int idx = 0; idx < info.length - 1; idx++) {
				String current = info[idx];
				node.count++;
				node = node.children.computeIfAbsent(current, c -> new Node());
			}
			int score = Integer.parseInt(info[4]);
			int index = getLowerBound(node.scores, score);
			node.scores.add(index, score);
		}

		private int getCount(String[] query) {
			return root.getCount(query, 0);
		}
	}

	private static class Node {
		Map<String, Node> children = new HashMap<>();
		List<Integer> scores = new ArrayList<>();
		int count;

		private int getCount(String[] query, int idx) {
			if (idx == 4) {
				int min = Integer.parseInt(query[4]);
				int lowerBound = getLowerBound(this.scores, min);
				return this.scores.size() - lowerBound;
			}
			String current = query[idx];
			int sum = 0;
			if (current.equals("-")) {
				for (Node child : children.values()) {
					sum += child.getCount(query, idx + 1);
				}
			}
			if (children.containsKey(current)) {
				Node node = children.get(current);
				sum += node.getCount(query, idx + 1);
			}
			return sum;
		}
	}

	private static int getLowerBound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size() - 1; // index
		// l가 r랑 같아질때 까지
		while (left <= right) {
			int mid = (left + right) / 2;
			if (list.get(mid) < target) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return left;
	}
}
