package 기출.우테코2020;

import java.util.HashSet;
import java.util.Set;

public class 오번 {
	public static void main(String[] args) {
		solution("10", "10", "10", "10");
	}

	public static String solution(String penter, String pexit, String pescape, String data) {
		int unitLength = penter.length();
		Set<String> pSet = new HashSet<>();
		pSet.add(penter);
		pSet.add(pescape);
		pSet.add(pexit);

		StringBuilder answer = new StringBuilder();
		answer.append(penter);
		if (data.length() < unitLength) {
			answer.append(data);
		} else {
			for (int startIdx = 0; startIdx < data.length(); startIdx += unitLength) {
				String subData = data.substring(startIdx, startIdx + unitLength);
				if (pSet.contains(subData)) {
					answer.append(pescape);
				}
				answer.append(subData);
			}
		}
		answer.append(pexit);
		System.out.println(answer.toString());
		return answer.toString();
	}
}
