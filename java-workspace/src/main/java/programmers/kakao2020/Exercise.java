package programmers.kakao2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] positions = Arrays.stream(input.split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();
        System.out.println(Arrays.toString(positions));
        String [] second = br.readLine().split(" ");
        int v = Integer.parseInt(second[0]);
        int a = Integer.parseInt(second[1]);
        int d = Integer.parseInt(second[2]);
        int len = positions[1] - positions[0];
        if(v+a*len >= d) {
            System.out.println("1");
        } else{
            System.out.println("0");
        }
    }
}
