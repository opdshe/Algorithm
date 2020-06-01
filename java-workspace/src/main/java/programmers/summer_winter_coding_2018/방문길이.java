package programmers.summer_winter_coding_2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class 방문길이 {
    public static void main(String[] args) {
        solution("ULURRDLLU");
    }

    public static int solution(String dirs) {
        Robot robot = new Robot();
        for (int i = 0; i < dirs.length(); i++) {
            robot.move(dirs.charAt(i));
        }
        int answer = robot.count;
        System.out.println(answer);
        return answer;
    }


    private static class Robot {
        private int row = 5;
        private int column = 5;
        private List<Road> roads = new ArrayList<>();
        private int count = 0;

        private void move(char oper) {
            int nextRow = row;
            int nextColumn = column;
            if (oper==('U')) {
                nextRow = row - 1;
            } else if (oper==('D')) {
                nextRow = row + 1;
            } else if (oper==('R')) {
                nextColumn = column + 1;
            } else if (oper==('L')) {
                nextColumn = column - 1;
            }
            if (isMovable(nextRow, nextColumn)) {
                Road a = new Road();
                a.from = new Coord(row, column);
                a.to = new Coord(nextRow, nextColumn);
                Road b = new Road();
                b. from = new Coord(nextRow, nextColumn);
                b. to = new Coord(row, column);
                if (!roads.contains(a) && !roads.contains(b)){
                    roads.add(a);
                    count++;
                }
                row = nextRow;
                column = nextColumn;
            }
        }

        private boolean isMovable(int nextRow, int nextColumn) {
            return nextColumn >= 0 && nextColumn <= 10 && nextRow >= 0 && nextRow <= 10;
        }

        private class Coord {
            int y;
            int x;

            public Coord(int y, int x) {
                this.y = y;
                this.x = x;
            }

            @Override
            public String toString() {
                return "Coord{" +
                        "y=" + y +
                        ", x=" + x +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Coord coord = (Coord) o;
                return y == coord.y &&
                        x == coord.x;
            }
        }

        private class Road {
            Coord from;
            Coord to;

            @Override
            public String toString() {
                return "Road{" +
                        "from=" + from +
                        ", to=" + to +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Road road = (Road) o;
                return Objects.equals(from, road.from) &&
                        Objects.equals(to, road.to);
            }
        }
    }
}
