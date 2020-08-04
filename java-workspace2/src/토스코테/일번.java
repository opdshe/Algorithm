package 토스코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean answer = validateInput(input);
        System.out.println(answer);

    }
    private static boolean validateInput (String input) {
        int inputLength = input.length();
        boolean answer = true;
        if (input.charAt(inputLength-1)=='1'){
            return false;
        }
        for(int i = 0 ; i < inputLength-1; i++) {
            if (input.charAt(i)=='1') {
                if (input.charAt(i+1)!='2'){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
