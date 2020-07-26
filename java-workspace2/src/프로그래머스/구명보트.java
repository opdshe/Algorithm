package 프로그래머스;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        solution(new int[]{70,80,50}, 100);
    }

    public static int solution(int[] people, int limit) {
        //50 50 70 80
        Arrays.sort(people);
        int countOfPeople = people.length;
        int currentMinimumIdx = 0;
        int answer = 0;
        for (int currentMaxIdx = countOfPeople - 1; currentMaxIdx >= 0; currentMaxIdx--) {
            if( currentMinimumIdx>=currentMaxIdx) {
                if (currentMaxIdx == currentMinimumIdx) {
                    answer++;
                }
                break;
            }
            if (people[currentMaxIdx] + people[currentMinimumIdx] > limit) {
                answer++;
            } else {
                answer ++;
                currentMinimumIdx++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
