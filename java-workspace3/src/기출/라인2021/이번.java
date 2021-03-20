package 기출.라인2021;

import java.util.*;

public class 이번 {
	static Set<Character> specialCharacters = new HashSet<>();

	public int[] solution(String inp_str) {
		initSpecialCharacters();
		return checkPassword(inp_str);
	}

	private static int[] checkPassword(String password) {
		List<Integer> unMeet = new ArrayList<>();
		if (!isAvailableLength(password)) {
			unMeet.add(1);
		}
		if (!isAvailableCharacter(password)) {
			unMeet.add(2);
		}
		if (!hasOver3kind(password)) {
			unMeet.add(3);
		}

		if (hasContinuous4(password)) {
			unMeet.add(4);
		}
		if (hasDuplicate5(password)) {
			unMeet.add(5);
		}
		if (unMeet.size() == 0) {
			return new int[]{0};
		}
		return unMeet.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
	}

	private static boolean isAvailableLength(String origin) {
		return origin.length() >= 8 && origin.length() <= 15;
	}

	private static boolean isAvailableCharacter(String origin) {
		return origin.matches("^[a-zA-Z0-9~!@#$%^&*]*$");
	}

	private static boolean hasOver3kind(String origin) {
		int count = 0;
		if (hasLowerCase(origin)) {
			count++;
		}
		if (hasUpperCase(origin)) {
			count++;
		}
		if (hasDigit(origin)) {
			count++;
		}
		if (hasSpecialCharacter(origin)) {
			count++;
		}
		return count >= 3;
	}

	private static boolean hasLowerCase(String origin) {
		for (int idx = 0; idx < origin.length(); idx++) {
			if (Character.isLowerCase(origin.charAt(idx))) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasUpperCase(String origin) {
		for (int idx = 0; idx < origin.length(); idx++) {
			if (Character.isUpperCase(origin.charAt(idx))) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasDigit(String origin) {
		for (int idx = 0; idx < origin.length(); idx++) {
			if (Character.isDigit(origin.charAt(idx))) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasSpecialCharacter(String origin) {
		for (int idx = 0; idx < origin.length(); idx++) {
			if (specialCharacters.contains(origin.charAt(idx))) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasContinuous4(String origin) {
		char current = origin.charAt(0);
		int count = 0;
		for (int idx = 0; idx < origin.length(); idx++) {
			if (count >= 4) {
				return true;
			}
			if (current == origin.charAt(idx)) {
				count++;
			} else {
				current = origin.charAt(idx);
				count = 1;
			}
		}
		return count >= 4;
	}

	private static boolean hasDuplicate5(String origin) {
		Map<Character, Integer> counts = new HashMap<>();
		for (int idx = 0; idx < origin.length(); idx++) {
			Integer count = counts.getOrDefault(origin.charAt(idx), 0);
			count++;
			if (count >= 5) {
				return true;
			}
			counts.put(origin.charAt(idx), count);
		}
		return false;
	}

	private static void initSpecialCharacters() {
		specialCharacters.add('~');
		specialCharacters.add('!');
		specialCharacters.add('@');
		specialCharacters.add('#');
		specialCharacters.add('$');
		specialCharacters.add('%');
		specialCharacters.add('^');
		specialCharacters.add('&');
		specialCharacters.add('*');
	}
}
