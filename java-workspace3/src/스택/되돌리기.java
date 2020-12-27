package 스택;


import java.util.Scanner;
import java.util.Stack;

public class 되돌리기 {
    static Scanner scanner = new Scanner(System.in);
    static StringBuilder answer = new StringBuilder();
    static Stack<Order> stack = new Stack<>();

    public static void main(String[] args) {
        int countOfOrder = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countOfOrder; i++) {
            String[] order = scanner.nextLine().split(" ");
            stack.push(new Order(order[0], order[1], Integer.parseInt(order[2])));
        }
        while (!stack.isEmpty()) {
            Order order = stack.pop();
            order.operate();
        }
        System.out.println(answer.toString());
    }

    private static class Order {
        String order;
        String value;
        int time;

        public Order(String order, String value, int time) {
            this.order = order;
            this.value = value;
            this.time = time;
        }

        private void operate() {
            if (order.equals("type")) {
                answer.insert(0, value);
            } else if (order.equals("undo")) {
                while (!stack.isEmpty() && stack.peek().time >= this.time - Integer.parseInt((this.value))) {
                    stack.pop();
                }
            }
        }
    }
}
