package 해시;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String kind = cloth[cloth.length - 1];
            Integer count = map.getOrDefault(kind, 0);
            count++;
            map.put(kind, count);
        }
        int count = map.values().stream()
                .mapToInt(value -> value + 1)
                .reduce(1, (a, b) -> a * b);
        return count - 1;
    }
}
