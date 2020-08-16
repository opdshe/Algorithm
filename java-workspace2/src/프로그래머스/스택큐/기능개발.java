package 프로그래머스.스택큐;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ansList = new ArrayList<>();
        List<Integer> proList = new ArrayList<>();
        List<Integer> spList = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            proList.add(progresses[i]);
            spList.add(speeds[i]);
        }

        int days = 0;
        while (!proList.isEmpty()) {
            int subNum = 0;
            for (int i = 0; i < proList.size(); i++) {
                proList.set(i, proList.get(i) + spList.get(i));
            }
            if (proList.get(0) >= 100) {
                for (int i = 0; i < proList.size(); i++) {
                    if (proList.get(i) >= 100) {
                        subNum += 1;
                    } else {
                        break;
                    }
                }
                for (int i = 0; i < subNum; i++) {
                    proList.remove(0);
                    spList.remove(0);
                }
                ansList.add(subNum);
            }

        }
        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        return answer;
    }
}
