package 구현;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 파일명정렬 {
    static List<File> fileList = new ArrayList<>();

    public static String[] solution(String[] files) {
        for (int idx = 0; idx < files.length; idx++) {
            String file = files[idx];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            boolean hasNumber = false;
            for (int i = 0; i < file.length(); i++) {
                char current = file.charAt(i);
                if (!hasNumber && !Character.isDigit(current)) {
                    head.append(current);
                } else if (Character.isDigit(current)) {
                    hasNumber = true;
                    number.append(current);
                } else if (hasNumber && !Character.isDigit(current)) {
                    tail = new StringBuilder(file.substring(i));
                    break;
                }
            }
            File f = new File(idx, head.toString(), number.toString(), tail.toString());
            fileList.add(f);
        }

        fileList.sort(new MyComparator());
        return fileList.stream()
                .map(file -> file.head + file.number + file.tail)
                .toArray(String[]::new);
    }

    private static class MyComparator implements Comparator<File> {

        @Override
        public int compare(File o1, File o2) {
            if (o1.head.compareToIgnoreCase(o2.head) > 0) {
                return 1;
            } else if (o1.head.compareToIgnoreCase(o2.head) == 0) {
                if (Integer.parseInt(o1.number) > Integer.parseInt(o2.number)) {
                    return 1;
                } else if (Integer.parseInt(o1.number) == Integer.parseInt(o2.number)) {
                    if (o1.idx > o2.idx) {
                        return 1;
                    }
                }
            }
            return -1;
        }
    }

    private static class File {
        int idx;
        String head;
        String number;
        String tail;

        public File(int idx, String head, String number, String tail) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
}
