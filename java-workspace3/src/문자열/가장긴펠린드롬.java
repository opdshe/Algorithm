package 문자열;

public class 가장긴펠린드롬 {
	public static void main(String[] args) {
		int answer = solution("ecdabbcadc");
		System.out.println(answer);
	}

	public static int solution(String origin) {
		int answer = 1;
		char[] charArray = origin.toCharArray();
		for (int length = origin.length(); length >= 2; length--) {
			for (int start = 0; start <= origin.length() - length; start++) {
				if (isPalindrome(charArray, length, start)) {
					return length;
				}
			}
		}
		return answer;
	}

	private static boolean isPalindrome(char[] charArray, int length, int start) {
		for (int offset = 0; offset < length / 2; offset++) {
			if (charArray[offset + start] != charArray[start + length - 1 - offset]) {
				return false;
			}
		}
		return true;
	}
}
