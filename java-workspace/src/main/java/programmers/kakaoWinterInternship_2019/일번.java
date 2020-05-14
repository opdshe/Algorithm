package programmers.kakaoWinterInternship_2019;

public class 일번 {
    static char[][] pad = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}, {'*', '0', '#'}};
    static StringBuilder answer = new StringBuilder();
    static Coord rightHand = new Coord();
    static Coord leftHand = new Coord();

    public static void main(String[] args) {
        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }

    public static String solution(int[] numbers, String hand) {
        leftHand.y = 3;
        leftHand.x = 0;
        rightHand.y = 3;
        rightHand.x = 2;

        for (int i : numbers) {
            push(Character.forDigit(i,10), hand);
        }
        System.out.println(answer.toString());
        return answer.toString();
    }

    public static void push(char n, String hand) {
        int row = -1;
        int col = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (pad[i][j] == n) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        System.out.println("n: " + n);
        System.out.println("row:" + row);
        System.out.println("col:" + col);
        System.out.println("=========");
        if (n == '1' || n == '4' || n == '7') {
            answer.append("L");
            leftHand.x=col;
            leftHand.y=row;

        } else if (n == '3' || n == '6' || n == '9') {
            answer.append("R");
            rightHand.x=col;
            rightHand.y=row;
        } else if (n == '2' || n == '5' || n == '8' || n == '0') {
            int leftLen = Math.abs(leftHand.y-row) + Math.abs(leftHand.x-col);
            int rightLen = Math.abs(rightHand.y-row) + Math.abs(rightHand.x-col);
            if (leftLen < rightLen) {
                answer.append("L");
                leftHand.x=col;
                leftHand.y=row;
            } else if (leftLen > rightLen) {
                answer.append("R");
                rightHand.x=col;
                rightHand.y=row;
            } else {
                if (hand.equals("right")) {
                    answer.append("R");
                    rightHand.x=col;
                    rightHand.y=row;
                } else {
                    answer.append("L");
                    leftHand.x=col;
                    leftHand.y=row;
                }
            }
        }
    }

    static class Coord {
        int x;
        int y;
    }
}
