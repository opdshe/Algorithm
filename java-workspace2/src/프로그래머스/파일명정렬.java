package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 파일명정렬 {
    public static void main(String[] args) {
        solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" });
    }

    public static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            File file = makeFile(files[i], i);
            fileList.add(file);
        }

        for (File file : fileList) {
            System.out.println(file);
        }
        return null;
    }

    private static File makeFile(String file, int idx) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        String tail = "";
        for (int i = 0; i < file.length(); i++) {
            if (!Character.isDigit(file.charAt(i)) && number.length() == 0) {
                head.append(file.charAt(i));
            }
            if (Character.isDigit(file.charAt(i))) {
                number.append(file.charAt(i));
            }
            if (!Character.isDigit(file.charAt(i)) && number.length() >= 1) {
                tail = file.substring(i);
                break;
            }
        }
        System.out.println("head: " + head.toString());
        System.out.println("number: " + number.toString());
        System.out.println("tail: " + tail);
        return new File(head.toString(), number.toString(), tail, idx);
    }

    static class File {
        String head;
        String number;
        String tail;
        int idx;

        public File(String head, String number, String tail, int idx) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return head + number + tail;
        }
    }
}
