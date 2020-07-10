package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();
        for (String p : participant) {
            participants.put(p, participants.getOrDefault(p, 0) + 1);
        }
        Arrays.stream(completion)
                .forEach(c -> {
                    participants.put(c, participants.get(c)-1);
                    if (participants.get(c)==0){
                        participants.remove(c);
                    }
                });
        String answer = participants.keySet().toArray()[0].toString();
        return answer;
    }
}
