package programmers.kakaoBlindRecruit_2018;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class 압축 {
    static int idx = 1;
    static String message;
    static List<Integer> answer = new ArrayList<>();
    static Map<Integer, String> dict;

    public static void main(String[] args) {
        //65~90
        solution("TOBEORNOTTOBEORTOBEORNOT");
        System.out.println(Arrays.toString(answer.toArray()));
    }

    public static int[] solution(String msg) {
        Map<Integer, String> dict = makeDict();
        message = msg;
        while (message.length() > 0){
            String logest = findLongest(msg, dict);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static Map<Integer, String> makeDict() {
        Map<Integer, String> dict = new HashMap<>();
        for (int i = 65; i <= 90; i++) {
            dict.put(idx, Character.toString(i));
            idx++;
        }
        return dict;
    }

    public static String findLongest(String msg, Map<Integer, String> dict) {
        String w = null;
        String c = null;
        for (int i = 1; i <= message.length(); i++) {
            String sub = message.substring(0, i);
            if (dict.containsValue(sub)) {
                w = sub;
                continue;
            }
            c = String.valueOf(message.charAt(i-1));
            break;
        }

        String finalW = w;
        dict.put(idx++, w+c);
        int ans = dict.keySet().stream()
                .filter(key->dict.get(key).equalsIgnoreCase(finalW))
                .findFirst()
                .get();
        answer.add(ans);
        message = message.substring(w.length());
        return w;
    }

}
