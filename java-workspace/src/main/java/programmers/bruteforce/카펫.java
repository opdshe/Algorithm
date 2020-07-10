package main.java.programmers.bruteforce;

public class 카펫 {
    public static void main(String[] args) {
        solution(10, 2);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = null;
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int currentBrown = (width * 2) + 2 * (height - 2);
                if (currentBrown == brown) {
                    int currentYellow = (width - 2) * (height - 2);
                    if (currentYellow == yellow) {
                        System.out.println("width =" + width + ", height = " +height);
                        answer = new int[]{width, height};
                        break;
                    }
                }
            }
        }
        return answer;
    }
}