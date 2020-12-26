package 분류안함;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CD {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (input[0] == 0 && input[1] == 0) {
                break;
            }
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            for (int idx = 0; idx < input[0]; idx++) {
                aList.add(Integer.parseInt(bufferedReader.readLine()));
            }
            for (int idx = 0; idx < input[1]; idx++) {
                bList.add(Integer.parseInt(bufferedReader.readLine()));
            }
            int count = 0;
            for (Integer integer : bList) {
                if (hasB(aList, integer)) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }

    private static boolean hasB(List<Integer> aList, int target) {
        int position = Collections.binarySearch(aList, target);
        return position >= 0;
    }
}
