package 구현;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class 방금그곡 {
    private static Song answer = new Song(0, "(None)");

    public static void main(String[] args) {
        solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
    }

    public static String solution(String m, String[] musicInfos) {
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        for (String musicInfo : musicInfos) {
            String[] split = musicInfo.split(",");
            String[] start = split[0].split(":");
            String[] end = split[1].split(":");

            split[3] = split[3].replaceAll("C#", "c");
            split[3] = split[3].replaceAll("D#", "d");
            split[3] = split[3].replaceAll("F#", "f");
            split[3] = split[3].replaceAll("G#", "g");
            split[3] = split[3].replaceAll("A#", "a");

            List<String> melodyUnit = getMelodyUnit(split[3]);
            LocalTime startTime = LocalTime.of(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
            LocalTime endTime = LocalTime.of(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
            long diff = startTime.until(endTime, ChronoUnit.MINUTES);
            String melody = getMelody(melodyUnit, diff);
            if (hasMelody(m, melody)) {
                if (answer.time < diff) {
                    answer = new Song(diff, split[2]);
                }
            }
        }
        System.out.println(answer.name);
        return answer.name;
    }

    private static boolean hasMelody(String target, String origin) {
        try {
            for (int idx = 0; idx <= origin.length() - target.length(); idx++) {
                String sub = origin.substring(idx, idx + target.length());
                if (sub.equals(target)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    private static List<String> getMelodyUnit(String melody) {
        List<String> melodyUnit = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int idx = 0; idx < melody.length(); idx++) {
            char current = melody.charAt(idx);
            if (idx == 0) {
                stringBuilder.append(current);
                continue;
            }
            if (Character.isAlphabetic(current)) {
                melodyUnit.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(current);
        }
        melodyUnit.add(stringBuilder.toString());
        return melodyUnit;
    }

    private static String getMelody(List<String> melodyUnit, long diff) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int idx = 0; idx < diff; idx++) {
            stringBuilder.append(melodyUnit.get(idx % melodyUnit.size()));
        }
        return stringBuilder.toString();
    }

    private static class Song {
        long time;
        String name;

        public Song(long time, String name) {
            this.time = time;
            this.name = name;
        }
    }
}
