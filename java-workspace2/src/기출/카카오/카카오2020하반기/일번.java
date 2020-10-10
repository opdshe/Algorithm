package 기출.카카오.카카오2020하반기;

public class 일번 {
	public static void main(String[] args) {
		solution("...!@BaT#*..y.abcdefghijklm");
	}

	public static String solution(String new_id) {
		String answer = getNewId(new_id);
		System.out.println(answer);
		return answer;
	}

	private static String getNewId(String origin) {

		String editString = toLowerCase(origin);
		editString = toCorrect(editString);
		editString = removeDuplicatedDot(editString);
		editString = removeFrontBackDot(editString);

		if (editString.length() == 0) {
			editString += "a";
		}
		if (editString.length() >= 16) {
			editString = editString.substring(0, 15);
		}
		if (editString.charAt(editString.length() - 1) == '.') {
			editString = editString.substring(0, editString.length() - 1);
		}
		if (editString.length() <= 2) {
			char target = editString.charAt(editString.length() - 1);
			while (editString.length() < 3) {
				editString += target;
			}
		}

		return editString;
	}

	private static String toLowerCase(String origin) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < origin.length(); i++) {
			stringBuilder.append(Character.toLowerCase(origin.charAt(i)));
		}
		return stringBuilder.toString();
	}

	private static String toCorrect(String origin) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < origin.length(); i++) {
			if (Character.isDigit(origin.charAt(i))) {
				stringBuilder.append(origin.charAt(i));
			} else if (origin.charAt(i) == '-') {
				stringBuilder.append(origin.charAt(i));
			} else if (origin.charAt(i) == '_') {
				stringBuilder.append(origin.charAt(i));
			} else if (origin.charAt(i) == '.') {
				stringBuilder.append(origin.charAt(i));
			} else if (Character.isLowerCase(origin.charAt(i))) {
				stringBuilder.append(origin.charAt(i));
			}
		}
		return stringBuilder.toString();
	}

	private static String removeDuplicatedDot(String origin) {
		StringBuilder stringBuilder = new StringBuilder();
		int count = 0;
		for (int i = 0; i < origin.length(); i++) {
			if (origin.charAt(i) == '.') {
				count++;
			} else {
				if (count >= 1) {
					stringBuilder.append(".");
				}
				stringBuilder.append(origin.charAt(i));
				count = 0;
			}
		}
		if (count >= 1) {
			stringBuilder.append(".");
		}
		return stringBuilder.toString();
	}

	private static String removeFrontBackDot(String origin) {
		if (origin.charAt(0) == '.') {
			origin = origin.substring(1);
		}
		if (origin.equals("")) {
			return "";
		}
		if (origin.charAt(origin.length() - 1) == '.') {
			System.out.println(origin);
			origin = origin.substring(0, origin.length() - 1);
		}
		return origin;
	}
}
