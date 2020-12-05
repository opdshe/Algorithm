package 구현;

public class 스킬트리 {
    public static void main(String[] args) {
        solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            if (isAvailable(skill, skill_tree)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isAvailable(String skill, String target) {
        boolean[] visited = new boolean[26];
        int[] prev = new int[26];
        boolean isAvailable = true;
        for (int idx = 1; idx < skill.length(); idx++) {
            char currentChar = skill.charAt(idx);
            char prevChar = skill.charAt(idx - 1);
            prev[(int) currentChar - 65] = prevChar;
        }

        for (int idx = 0; idx < target.length(); idx++) {
            char currentChar = target.charAt(idx);
            int mustVisit = prev[(int) currentChar - 65];
            if (mustVisit != 0) {
                if (!visited[mustVisit - 65]) {
                    isAvailable = false;
                    break;
                } else {
                    visited[(int) currentChar - 65] = true;
                }
            } else {
                visited[(int) currentChar - 65] = true;
            }
        }
        return isAvailable;
    }
}
