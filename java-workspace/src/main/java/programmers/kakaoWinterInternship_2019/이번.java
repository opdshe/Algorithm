package programmers.kakaoWinterInternship_2019;

import java.util.*;

public class 이번 {
    static List<Character> totalOperrator = new ArrayList<>();
    static List<List<Integer>> total = new ArrayList<>();
    static List<List<Character>> totalOrder = new ArrayList<>();
    static List<Character> oper = Arrays.asList('*', '-', '+');
    static int maxValue = -1;
    static int answer = 0 ;

    public static void main(String[] args) {

        solution("100-200*300-500+20");
    }

    public static long solution(String expression) {
        List<Character> operList =new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (oper.contains(expression.charAt(i)) && !totalOperrator.contains(expression.charAt(i))) {
                totalOperrator.add(expression.charAt(i));
            }
        }
        for (int i = 0; i < expression.length(); i++) {
            if (oper.contains(expression.charAt(i))) {
                operList.add(expression.charAt(i));
            }
        }
        List<Integer> contain = new ArrayList<>();
        makeCom(contain);
        setTotalOrder();
        System.out.println(operList);
        for(List<Character> l : totalOrder) {
            getOneValue(expression, l, operList);
        }
        System.out.println("answer :" + answer);
        return answer;
    }

    public static void makeCom(List<Integer> contain) {
        if (contain.size() == totalOperrator.size()) {
            total.add(contain);
        }
        for (int i = 0; i < totalOperrator.size(); i++) {
            if (!contain.contains(i)) {
                List<Integer> newContain = new ArrayList<>();
                newContain.addAll(contain);
                newContain.add(i);
                makeCom(newContain);
            }
        }
    }

    public static void setTotalOrder() {
        for (List<Integer> l : total) {
            List<Character> order = new ArrayList<>();
            for (Integer i : l) {
                order.add(totalOperrator.get(i));
            }
            totalOrder.add(order);
        }
    }

    public static void getOneValue(String expression, List<Character> order, List<Character> operList) {
        String exSet = expression.replaceAll("[*+-]", ",");
        List<String> myList = new ArrayList<>();
        myList.addAll(Arrays.asList(exSet.split(",")));
        List<Integer> calcOrder= new ArrayList<>();
        System.out.println("order : " + order);
        System.out.println("operList" + operList);

        for (int i = 0; i < order.size(); i ++) {
            char operator = order.get(i);
            for ( int j = 0; j < operList.size(); j ++){
                if (operList.get(j)==operator) {
                    calcOrder.add((j));
                }
            }
        }
        System.out.println("calcOrder :" + calcOrder);

        int count =0;
        while (!calcOrder.isEmpty()) {
            int changed = 0;
            int idx = calcOrder.remove(0);
            char operator = operList.get(idx);
            System.out.println(Arrays.toString(myList.toArray()));
            System.out.println("idx " + idx);
            System.out.println("oper: " + operator);
            String a;
            String b;
            try{
               a = myList.remove(idx-count);
               b = myList.remove(idx-count );
            } catch (IndexOutOfBoundsException e) {
                a = myList.remove(0);
                b = myList.remove(0);
            }

            if (operator == '+') {
                System.out.println(a + " + " + b);
                changed = Integer.parseInt(a) + Integer.parseInt(b);
            } else if (operator == '*') {
                System.out.println(a + " * " + b);
                changed = Integer.parseInt(a) * Integer.parseInt(b);
            } else if (operator == '-') {
                System.out.println(a + " - " + b);
                changed = Integer.parseInt(a) - Integer.parseInt(b);
            }
            try {
                myList.add(idx-count, String.valueOf(changed));
            } catch (IndexOutOfBoundsException e) {
                myList.add(0, String.valueOf(changed));
            }
            count ++;
        }
        int value = Math.abs(Integer.parseInt(myList.remove(0)));
        System.out.println("value :" + value);
        answer = Math.max(answer, value);
    }
}
