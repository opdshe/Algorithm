package programmers.kakaoBlindRecruit_2020;

public class 문자열_압축 {
    public static void main(String[] args) {
        solution("aabbaccc");
    }

    public static int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length()/2; i++) {
            answer = Math.min(answer,check(s, i).length());
        }
        return answer;
    }

    public static String check(String s, int length) {
        StringBuilder answer = new StringBuilder();
        String current = s.substring(0, length);
        int count = 0;
        int idx = 0;
        for (int i = 0; i < s.length() - length + 1; i+=length) {
            idx = i;
            String sub = s.substring(i, i + length);
            if (sub.equals(current)) {
                count++;
                continue;
            }
            answer.append(addString(current, count));
            current = sub;
            count = 1;
        }
        answer.append(addString(current, count));
        if (idx + length<s.length()) {
            answer.append(s.substring(idx + length));
        }
        System.out.println(answer);
        return answer.toString();
    }

    public static String addString(String current, int count) {
        StringBuilder answer = new StringBuilder();
        if (count == 1) {
            answer.append(current);
        } else {
            answer.append(count).append(current);
        }
        return answer.toString();
    }
}