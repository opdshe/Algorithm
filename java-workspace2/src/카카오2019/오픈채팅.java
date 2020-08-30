package 카카오2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅 {
	static Map<String, String> userInfo = new HashMap<>();
	static String[] order;

	public static void main(String[] args) {
		solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
	}

	public static String[] solution(String[] record) {
		int recordLength = record.length;
		order = new String[recordLength];
		List<String> answer = new ArrayList<>();
		for (int i = 0; i < recordLength; i++) {
			String[] inputs = record[i].split(" ");
			if (inputs.length == 2) {
				order[i] = "L " + inputs[1];
			} else {
				if (inputs[0].equals("Enter")) {
					userInfo.put(inputs[1], inputs[2]);
					order[i] = "E " + inputs[1];
				} else {
					userInfo.put(inputs[1], inputs[2]);
					order[i] = "C " + inputs[1];
				}
			}
		}
		for (int i = 0; i < recordLength; i++) {
			String[] split = order[i].split(" ");
			if (split[0].equals("C")) {
				continue;
			}
			if (split[0].equals("E")) {
				answer.add(userInfo.get(split[1]) + "님이 들어왔습니다.");
				continue;
			}
			answer.add(userInfo.get(split[1]) + "님이 나갔습니다.");
		}
		return answer.toArray(new String[answer.size()]);
	}
}