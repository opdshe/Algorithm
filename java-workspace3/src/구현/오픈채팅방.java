package 구현;

import java.util.*;

public class 오픈채팅방 {
    static Map<String, String> userInfo = new HashMap<>();

    public String[] solution(String[] records) {
        Queue<Record> queue = new ArrayDeque<>();
        List<String> answers = new ArrayList<>();
        for (String record : records) {
            String[] split = record.split(" ");
            if (split[0].equals("Enter")) {
                userInfo.put(split[1], split[2]);
                queue.add(new Record(split[0], split[1]));
            } else if (split[0].equals("Leave")) {
                queue.add(new Record(split[0], split[1]));
            } else {
                userInfo.put(split[1], split[2]);
            }
        }
        while (!queue.isEmpty()) {
            Record record = queue.poll();
            answers.add(record.getText());
        }
        return answers.toArray(new String[0]);
    }

    private static class Record {
        String command;
        String uid;

        public Record(String command, String uid) {
            this.command = command;
            this.uid = uid;
        }

        private String getText() {
            String name = userInfo.get(uid);
            if (command.equals("Enter")) {
                return name + "님이 들어왔습니다.";
            } else {
                return name + "님이 나갔습니다.";
            }
        }
    }
}
