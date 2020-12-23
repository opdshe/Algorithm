package 시뮬레이션;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 프린터큐 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = scanner.nextInt();
        for (int test = 0; test < testcase; test++) {
            List<Document> documents = new ArrayList<>();
            int countOfDocument = scanner.nextInt();
            int target = scanner.nextInt();
            for (int idx = 0; idx < countOfDocument; idx++) {
                documents.add(new Document(idx, scanner.nextInt()));
            }
            solution(documents, target);
        }
    }

    private static int solution(List<Document> documents, int target) {
        int order = 0;
        while (true) {
            Document head = documents.get(0);
            if (hasHigherPriority(documents, head.priority)) {
                documents.remove(head);
                documents.add(head);
            } else {
                order++;
                documents.remove(head);
                if (head.idx == target) {
                    break;
                }
            }
        }
        System.out.println(order);
        return order;
    }

    private static boolean hasHigherPriority(List<Document> documents, int priority) {
        return documents.stream()
                .anyMatch(document -> document.priority > priority);
    }

    private static class Document {
        int idx;
        int priority;

        public Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}


