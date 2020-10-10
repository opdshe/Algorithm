package 기출.카카오.카카오2020인턴;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {
	static String[] operator = new String[]{"+", "-", "*"};
	static List<String> total = new ArrayList<>();
	static boolean[] visited;
	static int[] priority;
	static long answer = -Long.MAX_VALUE;

	public static void main(String[] args) {
		solution("1*3");
	}

	public static long solution(String expression) {
		parsing(expression);
		visited = new boolean[3];
		priority = new int[3];
		dfs(0);
		System.out.println(answer);
		return answer;
	}

	private static void parsing(String expression) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int idx = 0; idx < expression.length(); idx++) {
			//특문
			if (!Character.isDigit(expression.charAt(idx))) {
				total.add(stringBuilder.toString());
				total.add(String.valueOf(expression.charAt(idx)));
				stringBuilder = new StringBuilder();
			} else {
				stringBuilder.append(expression.charAt(idx));
			}
		}
		total.add(stringBuilder.toString());
	}

	private static void dfs(int level) {
		if (level == 3) {
			List<String> copyTotal = new ArrayList<>(total);
			for (int i = 0; i < 3; i++) {
				operate(copyTotal, operator[priority[i]]);
			}
			answer = Math.max(answer, Math.abs(Long.parseLong(copyTotal.get(0))));
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (!visited[i]) {
				visited[i] = true;
				priority[level] = i;
				dfs(level + 1);
				visited[i] = false;
			}
		}
	}

	private static void operate(List<String> copyTotal, String operator) {
		boolean hasChange = false;
		do {
			hasChange = false;
			for (int i = 0; i < copyTotal.size(); i++) {
				if (copyTotal.get(i).equals(operator)) {
					int targetIdx = i - 1;
					long left = Long.parseLong(copyTotal.remove(targetIdx));
					String opt = copyTotal.remove(targetIdx);
					long right = Long.parseLong(copyTotal.remove(targetIdx));
					copyTotal.add(targetIdx, String.valueOf(calculate(left, right, opt)));
					hasChange = true;
					break;
				}
			}
		} while (hasChange);
	}

	private static long calculate(long left, long right, String opt) {
		if (opt.equals("+")) {
			return left + right;
		} else if (opt.equals("-")) {
			return left - right;
		}
		return left * right;
	}
}