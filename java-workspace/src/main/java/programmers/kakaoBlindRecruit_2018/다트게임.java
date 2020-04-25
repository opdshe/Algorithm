package programmers.kakaoBlindRecruit_2018;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class 다트게임 {
    static final int totalRound = 3;
    static List<String> results = new ArrayList<>();
    static StringBuilder stringBuilder;
    static List<Integer> scores = new ArrayList<>();

    public static void main(String[] args) {
        solution("1D2S#10S");
        System.out.println(scores.stream().reduce(Integer::sum).orElse(0));
    }

    public static int solution(String dartResult) {
        makeThreeRound(dartResult);
        for (int i = 0; i < totalRound; i++) {
            playOneRound(results.get(i), i);
        }
        return scores.stream().reduce(Integer::sum).orElse(0);
    }

    public static String makeThreeRound(String dartResult) {
        stringBuilder = new StringBuilder();
        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) {
                if (stringBuilder.length() != 0) {
                    if (dartResult.charAt(i - 1) == '1') {
                        stringBuilder.append(dartResult.charAt(i));
                        continue;
                    }
                    results.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
            stringBuilder.append(dartResult.charAt(i));
        }
        results.add(stringBuilder.toString());
        return "ok";
    }

    private static void playOneRound(String result, int idx) {
        int currValue = 0;

        for (int i = 0; i < result.length(); i++) {
            if (Character.isDigit(result.charAt(i))) {
                if (currValue > 0) {
                    currValue = Integer.parseInt(String.valueOf(currValue) + result.charAt(i));
                    continue;
                }
                currValue = Integer.parseInt(String.valueOf(result.charAt(i)));
                continue;
            }
            if (Character.isUpperCase(result.charAt(i))) {
                switch (result.charAt(i)) {
                    case 'S':
                        currValue = (int) Math.pow(currValue, 1);
                        break;
                    case 'D':
                        currValue = (int) Math.pow(currValue, 2);
                        break;
                    case 'T':
                        currValue = (int) Math.pow(currValue, 3);
                        break;
                }
                continue;
            }
            if (result.charAt(i) == '*') {
                try {
                    scores.set(idx - 1, scores.get(idx - 1) * 2);
                } catch (IndexOutOfBoundsException e) {
                }
                currValue *= 2;
                continue;
            }
            if (result.charAt(i) == '#') {
                currValue *= -1;
                continue;
            }
        }
        scores.add(currValue);
    }

    Function<Integer, Integer> singleScore = i -> (int) Math.pow(i, 1);
    Function<Integer, Integer> doubleScore = i -> (int) Math.pow(i, 2);
    Function<Integer, Integer> tripleScore = i -> (int) Math.pow(i, 3);

}
