package 프로그래머스;

public class 키패드누르기 {
    static String currentLeft = "*";
    static String currentRight = "#";

    public static void main(String[] args) {
        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }

    public static String solution(int[] numbers, String hand) {
        String[][] keypad = setKeypad();
        StringBuilder answer = new StringBuilder();
        for (int number : numbers) {
            answer.append(addAnswer(keypad, number, hand));
        }
        System.out.println(answer);
        return answer.toString();
    }

    private static String[][] setKeypad() {
        String[][] keypad = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"*", "0", "#"}
        };
        return keypad;
    }

    private static String addAnswer(String[][] keypad, int num, String hand) {
        String input = String.valueOf(num);
        if (input.equals("1") || input.equals("4") ||
                input.equals("7") || input.equals("*")) {
            currentLeft = input;
            return "L";
        }
        if (input.equals("3") || input.equals("6") ||
                input.equals("9") || input.equals("#")) {
            currentRight = input;
            return "R";
        }
        return getFingerForMiddleZone(keypad, input, hand);
    }

    private static String getFingerForMiddleZone(String[][] keypad, String target, String hand) {
        int[][] leftPosition = getPosition(keypad, currentLeft);
        int[][] rightPosition = getPosition(keypad, currentRight);
        int[][] targetPosition = getPosition(keypad, target);

        int leftDistance = Math.abs(leftPosition[0][0] - targetPosition[0][0]) +
                Math.abs(leftPosition[0][1] - targetPosition[0][1]);
        int rightDistance = Math.abs(rightPosition[0][0] - targetPosition[0][0]) +
                Math.abs(rightPosition[0][1] - targetPosition[0][1]);
        if (leftDistance < rightDistance) {
            currentLeft = target;
            return "L";
        }
        if (leftDistance > rightDistance) {
            currentRight = target;
            return "R";
        }
        if(hand.equals("left")) {
            currentLeft = target;
            return "L";
        }
        currentRight = target;
        return "R";
    }

    private static int[][] getPosition(String[][] keypad, String target) {
        int[][] answer = new int[1][2];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 3; x++) {
                if (keypad[y][x].equals(target)) {
                    answer[0][0] = y;
                    answer[0][1] = x;
                }
            }
        }
        return answer;
    }
}
