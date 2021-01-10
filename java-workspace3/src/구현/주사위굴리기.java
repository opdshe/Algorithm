package 구현;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 주사위굴리기 {
    static Scanner scanner = new Scanner(System.in);
    static int maxRow;
    static int maxColumn;
    static int[][] map;
    static int row;
    static int column;
    static Dice dice;
    static Map<Integer, int[]> directions = new HashMap<>();

    static {
        directions.put(1, new int[]{0, 1});
        directions.put(2, new int[]{0, -1});
        directions.put(3, new int[]{-1, 0});
        directions.put(4, new int[]{1, 0});
    }

    public static void main(String[] args) {
        maxRow = scanner.nextInt();
        maxColumn = scanner.nextInt();
        row = scanner.nextInt();
        column = scanner.nextInt();
        int countOfOrder = scanner.nextInt();
        map = new int[maxRow][maxColumn];
        for (int r = 0; r < maxRow; r++) {
            for (int c = 0; c < maxColumn; c++) {
                map[r][c] = scanner.nextInt();
            }
        }
        dice = new Dice(row, column);
        for (int o = 0; o < countOfOrder; o++) {
            int direction = scanner.nextInt();
            int[] offset = directions.get(direction);
            int nextRow = dice.row + offset[0];
            int nextColumn = dice.column + offset[1];
            if (isAvailablePosition(nextRow, nextColumn)) {
                dice.move(direction, nextRow, nextColumn);
                if (map[nextRow][nextColumn] == 0) {
                    map[nextRow][nextColumn] = dice.one;
                } else {
                    dice.one = map[nextRow][nextColumn];
                    map[nextRow][nextColumn] = 0;
                }
                System.out.println(dice.six);
            }
        }
    }

    private static boolean isAvailablePosition(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < maxRow &&
                nextColumn >= 0 && nextColumn < maxColumn;
    }

    private static class Dice {
        int row;
        int column;
        int one;
        int two;
        int three;
        int four;
        int five;
        int six;

        public Dice(int row, int column) {
            this.row = row;
            this.column = column;
        }

        private void move(int direction, int nextRow, int nextColumn) {
            row = nextRow;
            column = nextColumn;

            int tempOne = one;
            int tempTwo = two;
            int tempThree = three;
            int tempFour = four;
            int tempFive = five;
            int tempSix = six;
            if (direction == 1) {
                one = tempThree;
                four = tempOne;
                six = tempFour;
                three = tempSix;
            } else if (direction == 2) {
                one = tempFour;
                four = tempSix;
                six = tempThree;
                three = tempOne;
            } else if (direction == 3) {
                five = tempOne;
                six = tempFive;
                two = tempSix;
                one = tempTwo;
            } else if (direction == 4) {
                one = tempFive;
                five = tempSix;
                six = tempTwo;
                two = tempOne;
            }
        }
    }
}
