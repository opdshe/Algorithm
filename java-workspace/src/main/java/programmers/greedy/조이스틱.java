package programmers.greedy;

public class 조이스틱 {
    public static void main(String[] args) {
        solution("ABABAAAAABA");
    }

    public static int solution(String name) {
        int answer = 0;
        answer += countSide(name);
        answer += countUpDown(name);
        System.out.println(answer);
        return answer;
    }

    private static int countSide(String name) {
        if (name.length() == 1){
            return 0;
        }
        int aheadCount = 0;
        int goBackCount = 0;
        for (int i = 0; i < name.length(); i++) {
            if (i == 0) {
                continue;
            }
            aheadCount++;
            if (name.charAt(i) != 'A') {
                break;
            }
        }
        for (int i = name.length(); i > 0; i--) {
            if (i == name.length()) {
                continue;
            }
            goBackCount++;
            if (name.charAt(i) != 'A') {
                break;
            }
        }
        int answer = name.length() -  Math.max(aheadCount, goBackCount);
        System.out.println("countSide = " + answer);
        return answer;
    }

    private static int countUpDown(String name) {
        int answer = 0;
        for (int i = 0; i < name.length(); i++) {
            if (Character.getNumericValue(name.charAt(i)) <= 22) {
                answer += Character.getNumericValue(name.charAt(i)) - 10;
                continue;
            }
            answer += Character.getNumericValue('Z') - Character.getNumericValue(name.charAt(i)) + 1;
        }
        System.out.println("UpDown = " + answer);
        return answer;
    }
}
