package 시뮬레이션;

import java.util.ArrayList;
import java.util.List;

public class 프린터 {
	public static void main(String[] args) {
		solution(new int[]{2, 1, 3, 2}, 2);
	}

	public static int solution(int[] priorities, int location) {
		List<Document> documents = new ArrayList<>();
		for (int idx = 0; idx < priorities.length; idx++) {
			documents.add(new Document(idx, priorities[idx]));
		}
		return print(documents, location);
	}

	private static int print(List<Document> documents, int location) {
		int count = 0;
		while (true) {
			Document head = documents.remove(0);
			boolean hasHigherPriority = false;
			for (Document document : documents) {
				if (document.priority > head.priority) {
					hasHigherPriority = true;
					break;
				}
			}
			if (hasHigherPriority) {
				documents.add(head);
			} else {
				count++;
				if (head.idx == location) {
					break;
				}
			}
		}
		return count;
	}

	private static class Document {
		private int idx;
		private int priority;

		public Document(int idx, int priority) {
			this.idx = idx;
			this.priority = priority;
		}
	}
}