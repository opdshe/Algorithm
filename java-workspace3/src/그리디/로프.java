package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 로프 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int countOfRope = Integer.parseInt(bufferedReader.readLine());
        List<Integer> ropes = new ArrayList<>();
        for (int i = 0; i < countOfRope; i++) {
            ropes.add(Integer.parseInt(bufferedReader.readLine()));
        }
        ropes.sort(Comparator.naturalOrder());
        int answer = 0;
        for (int idx = 0; idx < countOfRope; idx++) {
            int rope = ropes.get(idx);
            int count = countOfRope - idx;
            int weight = rope * count;
            answer = Math.max(answer, weight);
        }
        System.out.println(answer);
    }
}
