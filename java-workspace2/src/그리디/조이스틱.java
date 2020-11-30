package 그리디;

public class 조이스틱 {
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solution("BBBAAAB");
    }

    public static int solution(String name) {
        StringBuilder rightDir = new StringBuilder("A".repeat(name.length()));
        checkRightDirection(name, rightDir, 0, 0);

        StringBuilder reverseDir = new StringBuilder("A".repeat(name.length()));
        int firstIndexCost = getMinYMovement(name.charAt(0));
        reverseDir.setCharAt(0, name.charAt(0));
        checkReverseDirection(name, reverseDir, name.length() - 1, firstIndexCost);

        System.out.println(answer);
        return answer;
    }

    private static void checkRightDirection(String target, StringBuilder s, int idx, int cost) {
        if (s.toString().equals(target)) {
            answer = Math.min(answer, cost);
            return;
        }
        s.setCharAt(idx, target.charAt(idx));
        int additionalCost = getMinYMovement(s.charAt(idx));
        checkRightDirection(target, s, idx + 1, cost + additionalCost + 1);
    }

    private static void checkReverseDirection(String target, StringBuilder s, int idx, int cost) {
        if (s.toString().equals(target)) {
            answer = Math.min(answer, cost);
            return;
        }
        s.setCharAt(idx, target.charAt(idx));
        int additionalCost = getMinYMovement(s.charAt(idx));
        checkReverseDirection(target, s, idx - 1, cost + additionalCost + 1);
    }


    private static int getMinYMovement(char target) {
        int rightDirection = (int) target - (int) 'A';
        int reverseDirection = (int) 'Z' - (int) target + 1;
        return Math.min(rightDirection, reverseDirection);
    }
}