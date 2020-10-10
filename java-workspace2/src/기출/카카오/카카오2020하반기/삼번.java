package 기출.카카오.카카오2020하반기;

import java.util.*;

public class 삼번 {
	static int countChild;

	public static void main(String[] args) {
		solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
				new String[]{"java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200",
						"cpp and - and senior and pizza 250",
						"- and backend and senior and - 150",
						"- and - and - and chicken 100",
						"- and - and - and - 150"});
	}

	public static int[] solution(String[] info, String[] query) {
		Trie trie = new Trie();
		int[] answer = new int[query.length];
		for (String s : info) {
			trie.add(s.split(" "));
		}
		for (int i = 0; i < query.length; i++) {
			answer[i] = trie.newGetCount(arrangeString(query[i].split(" ")));
		}
		return answer;
	}

	private static String[] arrangeString(String[] origin) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String s : origin) {
			if (s.equals("and")) {
			} else {
				stringBuilder.append(" ").append(s);
			}
		}
		String answer = stringBuilder.toString().trim();
		return answer.split(" ");
	}

	private static class Trie {
		Node root;

		private Trie() {
			root = new Node();
		}

		private void add(String[] info) {
			Node current = root;
			for (int idx = 0; idx < info.length - 1; idx++) {
				current.count++;
				current = current.child.computeIfAbsent(info[idx], c -> new Node());
			}
			current.scores.add(Integer.parseInt(info[info.length - 1]));
		}

		private int newGetCount(String[] query) {
			countChild = 0;
			root.newGetCount(0, query);
			return countChild;
		}
	}

	private static class Node {
		Map<String, Node> child = new HashMap<>();
		List<Integer> scores = new ArrayList<>();
		int count;

		private void newGetCount(int idx, String[] query) {
			if (idx == 4) {
				this.scores.sort(Comparator.naturalOrder());
				for (Integer score : this.scores) {
					if (score >= Integer.parseInt(query[query.length - 1])) {
						countChild++;
					}
				}
				return;
			}
			if (query[idx].equals("-")) {
				for (Map.Entry<String, Node> stringNodeEntry : this.child.entrySet()) {
					Node childNode = stringNodeEntry.getValue();
					childNode.newGetCount(idx + 1, query);
				}
			}
			if (this.child.containsKey(query[idx])) {
				Node node = child.get(query[idx]);
				node.newGetCount(idx + 1, query);
			}
		}
	}
}
