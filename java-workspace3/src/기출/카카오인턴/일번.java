package 기출.카카오인턴;

import java.util.HashMap;
import java.util.Map;

public class 일번 {
	public static void main(String[] args) {
		solution("one");
	}

	private static final Map<String, Integer> numbers = new HashMap<>();

	private static void init() {
		numbers.put("zero", 0);
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		numbers.put("four", 4);
		numbers.put("five", 5);
		numbers.put("six", 6);
		numbers.put("seven", 7);
		numbers.put("eight", 8);
		numbers.put("nine", 9);
	}

	public static int solution(String s) {
		init();
		int currentIdx = 0;
		StringBuilder answer = new StringBuilder();
		while (currentIdx < s.length()) {
			char character = s.charAt(currentIdx);
			if (Character.isDigit(character)) {
				answer.append(character);
				currentIdx++;
				continue;
			}
			for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
				String key = entry.getKey();
				if (currentIdx + key.length() <= s.length()) {
					String sub = s.substring(currentIdx, currentIdx + key.length());
					if (sub.equals(key)) {
						answer.append(entry.getValue());
						currentIdx += key.length();
						break;
					}
				}
			}
		}
		//System.out.println(answer.toString());
		return Integer.parseInt(answer.toString());
	}
}
