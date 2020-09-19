package 카카오.카카오상반기2020;

public class 문자열압축 {
	public static void main(String[] args) {
		solution("abababab");
	}

	public static int solution(String s) {
		int answer = s.length();
		for (int i = 1; i <= s.length() / 2; i++) {
			answer = Math.min(answer, getCompressedStringLength(s, i));
		}
		System.out.println(answer);
		return answer;
	}

	private static int getCompressedStringLength(String s, int unit) {
		String current = s.substring(0, unit);
		StringBuilder compressedString = new StringBuilder();
		int idx = 0;
		int count = 0;
		while (idx < s.length()) {
			if (idx + unit > s.length()) {
				compress(compressedString, count, current);
				current = s.substring(idx);
				count = 1;
				break;
			}
			String subString = s.substring(idx, idx + unit);
			if (subString.equals(current)) {
				count++;
			} else {
				compress(compressedString, count, current);
				current = subString;
				count = 1;
			}
			idx += unit;
		}
		compress(compressedString, count, current);
		System.out.println(compressedString);
		return compressedString.length();
	}

	private static void compress(StringBuilder stringBuilder, int count, String current) {
		if (count == 1) {
			stringBuilder.append(current);
		} else {
			stringBuilder.append(count).append(current);
		}
	}
}