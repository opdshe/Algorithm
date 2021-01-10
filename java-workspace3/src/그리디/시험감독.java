package 그리디;

import java.util.Scanner;

public class 시험감독 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfPlace = scanner.nextInt();
        int[] places = new int[countOfPlace];
        for (int i = 0; i < countOfPlace; i++) {
            places[i] = scanner.nextInt();
        }
        int main = scanner.nextInt();
        int sub = scanner.nextInt();
        long answer = getMinSupervisor(places, main, sub);
        System.out.println(answer);
    }

    private static long getMinSupervisor(int[] places, int main, int sub) {
        long count = places.length;
        for (int place : places) {
            place -= main;
            if (place > 0) {
                int share = place / sub;
                int remainder = place % sub;
                if (remainder == 0) {
                    count += share;
                } else {
                    count += (share + 1);
                }
            }
        }
        return count;
    }
}
