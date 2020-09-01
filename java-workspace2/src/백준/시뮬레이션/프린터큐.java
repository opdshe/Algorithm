package 백준.시뮬레이션;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 프린터큐 {
	static int turn;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCase = scanner.nextInt();
		for (int i = 0; i < testCase; i++) {
			List<Document> printer = new LinkedList<>();
			int countOfDocument = scanner.nextInt();
			int targetIdx = scanner.nextInt();
			for (int idx = 0; idx < countOfDocument; idx++) {
				printer.add(new Document(idx, scanner.nextInt()));
			}

			turn = 0;
			while (!printer.isEmpty()) {
				if (operate(printer, targetIdx)) {
					break;
				}
			}
			System.out.println(turn);
		}
	}

	private static boolean operate(List<Document> printer, int target) {
		if (hasHigherPriority(printer)) {
			printer.add(printer.remove(0));
			return false;
		}
		turn++;
		Document document = printer.remove(0);
		return document.idx == target;
	}

	private static boolean hasHigherPriority(List<Document> printer) {
		int headPriority = printer.get(0).priority;
		for (int i = 1; i < printer.size(); i++) {
			Document document = printer.get(i);
			if (document.priority > headPriority) {
				return true;
			}
		}
		return false;
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
