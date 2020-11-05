package 기출.우테코;

public class 칠번 {
	public static void main(String[] args) {
		solution("brorrrrorrrwn");
	}

	private static void solution(String cryptogram) {
		String prev = cryptogram;
		while (true) {
			cryptogram = compress(cryptogram);
			if (prev.equals(cryptogram)) {
				break;
			} else {
				prev = cryptogram;
			}
		}
		System.out.println(cryptogram);
	}

	private static String compress(String origin) {
		StringBuilder stringBuilder = new StringBuilder();
		char prev = origin.charAt(0);
		int count = 1;
		for (int idx = 1; idx < origin.length(); idx++) {
			if (origin.charAt(idx) != prev) {
				if (count == 1) {
					stringBuilder.append(prev);
				}
				prev = origin.charAt(idx);
				count = 1;
			} else {
				count++;
			}
		}
		if (count == 1) {
			stringBuilder.append(prev);
		}
		return stringBuilder.toString();
	}
}
