package programmers.kakaoWinterInternship_2019;

import java.util.*;

public class 불량_사용자 {
    static List<List<String>> candidates = new ArrayList<>();
    static Set<Set<String>> answer = new HashSet<>();

    public static void main(String[] args) {
        solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
    }

    public static int solution(String[] user_id, String[] banned_id) {
        int countOfBan = banned_id.length;
        int countOfUser = user_id.length;
        for (int b = 0; b < countOfBan; b++) {
            List<String> candidate = new ArrayList<>();
            for (int u = 0; u < countOfUser; u++) {
                if (isMeetCondition(user_id[u], banned_id[b])) {
                    candidate.add(user_id[u]);
                }
            }
            candidates.add(candidate);
        }
        Set<String> l =new HashSet<>();
        dfs(0, countOfBan, l);
        return answer.size();
    }

    public static boolean isMeetCondition(String s, String standard) {
        if (standard.length() != s.length()) {
            return false;
        }
        for (int i = 0; i < standard.length(); i++) {
            if (standard.charAt(i) != '*' && s.charAt(i) != standard.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int idx, int countOfBan, Set<String> l) {
        if (idx == countOfBan) {
            if (l.size() == countOfBan && !answer.contains(l)){
                answer.add(l);
            }
            return;
        }
        for (int i = 0; i < candidates.get(idx).size(); i++) {
            Set<String> next = new HashSet<>();
            next.addAll(l);
            next.add(candidates.get(idx).get(i));
            dfs(idx + 1, countOfBan, next);
        }
    }
}
