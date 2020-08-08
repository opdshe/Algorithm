package 백준;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int key_num= sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for( int i =1; i<=key_num; i++){
            queue.add(i);
        }
        while(queue.size()>0){
            if(queue.size()<=1){
                break;
            }
            queue.poll();
            if(queue.size()<=1){
                break;
            }
            int front=queue.poll();
            queue.add(front);
            if(queue.size()<=1) {
                break;
            }
        }
        System.out.print(queue.poll());
    }
}
