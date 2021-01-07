package 구현;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
    static Map<String, Integer> map = new HashMap<>();
    static String message;
    static List<Integer> answers = new ArrayList<>();
    static int value = 1;

    public static int[] solution(String msg) {
        message = msg;
        init();
        while (message.length() > 0) {
            System.out.println(message);
            getLongestString();
        }
        return answers.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static void getLongestString() {
        String w = null;
        String c = null;
        for (int end = 1; end <= message.length(); end++) {
            String sub = message.substring(0, end);
            if (map.containsKey(sub)) {
                w = message.substring(0, end);
                continue;
            }
            c = String.valueOf(message.charAt(end - 1));
            break;
        }
        answers.add(map.get(w));
        message = message.substring(w.length());
        map.put(w + c, value++);
    }

    private static void init() {
        for (int i = 65; i <= 90; i++) {
            map.put(String.valueOf((char) i), value);
            value++;
        }
    }
}
