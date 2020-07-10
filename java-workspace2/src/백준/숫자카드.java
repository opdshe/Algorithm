package 백준;

import java.util.*;
import java.util.stream.Collectors;

public class 숫자카드 {
    private static int n;
    private static int m;
    private static List<Integer> nList;
    private static List<Integer> mList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        nList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        m = Integer.parseInt(scanner.nextLine());
        mList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.sort(nList);
        List<Integer> answerList = new ArrayList<>();
        for(Integer target : mList) {
            answerList.add(binarySearch(target));
        }
        String answer = Arrays.toString(answerList.toArray()).replaceAll("[\\[\\],]", "")    ;
        System.out.println(answer);
    }

    private static int binarySearch(int target) {
        int min = 0;
        int max = n - 1;
        while (min < max) {
            int middle = (min + max) / 2;
            if (target == nList.get(middle)) {
                return 1;
            }
            if (target < nList.get(middle)) {
                max = middle - 1;
                continue;
            }
            if (target > nList.get(middle)) {
                min = middle + 1;
            }
        }
        if (nList.get(min)==target) {
            return 1;
        }
        return 0;
    }
}
