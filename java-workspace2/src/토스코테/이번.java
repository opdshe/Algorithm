package 토스코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean answer = validateInput(input);
        System.out.println(answer);

    }

    private static boolean validateInput(String input) {
        int[] numbers = Arrays.stream(input.split(" "))
                .distinct()
                .mapToInt(Integer::parseInt)
                .toArray();
        int countOfNumbers = numbers.length;

        if (!validateDuplicate(countOfNumbers)) {
            return false;
        }
        if (!validateNumber(numbers)) {
            return false;
        }
        return validateOrder(numbers, countOfNumbers);
    }

    private static boolean validateDuplicate(int countOfNumbers) {
        return countOfNumbers == 6;
    }

    private static boolean validateNumber(int[] numbers) {
        return Arrays.stream(numbers)
                .allMatch((int number) -> number >= 1 && number <= 45);
    }


    private static boolean validateOrder(int[] numbers, int countOfNumbers) {
        boolean result = true;
        for (int i = 0; i < countOfNumbers - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
