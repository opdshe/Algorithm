package programmers.summer_winter_coding_2018;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 스킬트리 {
    public static void main(String[] args) {
        solution("CBD", new String[]{"CBADE", "CBADF", "AECB", "BDA"});
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> skillList = new ArrayList<>();
        for (int i = 0; i < skill.length(); i++) {
            skillList.add(skill.charAt(i));
        }
        for (String skill_tree : skill_trees) {
            if (isAvailable(skillList, skill_tree)) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean isAvailable(List<Character> skillList, String skill_tree) {
        boolean answer = false;
        List<Integer> first_idxes = skillList.stream()
                .map(skill -> {
                    if (skill_tree.indexOf(skill) >= 0) {
                        return skill_tree.indexOf(skill);
                    }
                    return skill_tree.length() + 1;
                })
                .collect(Collectors.toList());
        System.out.println(first_idxes.toString());
        if (isRising(first_idxes, 0)) {
            answer = true;
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean isRising(List<Integer> first_idxes, int idx) {
        if (idx == first_idxes.size() - 1) {
            return true;
        }
        if (first_idxes.get(idx) <= first_idxes.get(idx + 1)) {
            return isRising(first_idxes, idx + 1);
        } else {
            return false;
        }
    }
}
