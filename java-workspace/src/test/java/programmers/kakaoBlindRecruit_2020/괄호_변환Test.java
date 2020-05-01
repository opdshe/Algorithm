package programmers.kakaoBlindRecruit_2020;

import org.junit.Test;


public class 괄호_변환Test {

    @Test
    public void 올바른_괄호_확인() {
        String s = "(()))(";
        boolean result =괄호_변환.isCorrect(s);
        System.out.println(result);
    }

}