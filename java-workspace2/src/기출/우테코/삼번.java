package 기출.우테코;


public class 삼번 {

	public static void main(String[] args) {
		solution("I love you");
	}

	private static void solution(String word) {
		for (int idx = 0; idx < word.length(); idx++) {
			if (Character.isAlphabetic(word.charAt(idx))) {
				//소문자
				if (Character.isLowerCase(word.charAt(idx))) {
					System.out.print((char) (219 - (int) word.charAt(idx)));
				} else if (Character.isUpperCase(word.charAt(idx))) {
					System.out.print((char) (155 - (int) word.charAt(idx)));
				}
			} else {
				System.out.print(word.charAt(idx));
			}
		}
	}
}
