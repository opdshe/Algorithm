package 토스코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 삼번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String answer = solution(input);
        System.out.println(answer);

    }

    private static String solution(String input) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> numbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            Integer slice;
            if (map.containsKey(number)) {
                slice = map.get(number);
            } else {
                //Integer value = Function.compute(number);
                //map.put(number, value);
            }
            //stringBuilder.append(slice).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
