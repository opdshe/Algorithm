package 프로그래머스;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 파일명정렬 {
    public static void main(String[] args) {
        //"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
        //"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
        solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
        System.out.println("F-".compareToIgnoreCase("A-"));
    }

    public static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            File file = makeFile(files[i], i);
            fileList.add(file);
        }

        fileList.sort((File a, File b) -> {
            if (a.head.compareToIgnoreCase(b.head) >= 1) {
                //System.out.println("comparing head, " + a.toString() + " > " + b.toString());
                return 1;
            } else if (a.head.compareToIgnoreCase(b.head) <= -1) {
                //System.out.println("comparing head, " + a.toString() + " < " + b.toString());
                return -1;
            }
            if (Integer.parseInt(a.number) > Integer.parseInt(b.number)) {
                //System.out.println("comparing number, " + a.toString() + " > " + b.toString());
                return 1;
            } else if (Integer.parseInt(a.number) < Integer.parseInt(b.number)) {
                //System.out.println("comparing head, " + a.toString() + " > " + b.toString());
                return -1;
            }
            if (a.idx > b.idx) {
                return 1;
            }
            return -1;
        });

        for (File file : fileList) {
            System.out.println("head: " + file.head +", number: " +file.number +", tail: " + file.tail );
        }
        String[] result = fileList.stream()
                .map(File::toString)
                .collect(Collectors.toList())
                .toArray(new String[0]);

        return result;
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

        public String toString() {
            return head + number + tail;
        }
    }
}
