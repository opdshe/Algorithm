package programmers.simulation;

import com.sun.tools.javac.util.Pair;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        solution( new int[][]{{5,-1,4},{6,3,-1},{2,-1,1}}, 1, 0, new String[] {"go","go","right","go","right","go","left","go"});
    }

    public static int solution(int[][] office, int r, int c, String[] move) {
        Robot myRobot = new Robot(office, r, c);
        myRobot.clean();
        Arrays.stream(move).forEach(order -> {
            myRobot.operate(order);
            myRobot.clean();
        });
        System.out.println(myRobot.totalCleaning);
        return myRobot.totalCleaning;
    }
}

class Robot {
    int[][] board;
    int totalCleaning;
    Pair<Integer, Integer> coord;
    int dir; //북 :0, 동:1, 남:2 서:3

    public Robot(int[][] office, int r, int c){
        board = office;
        totalCleaning = 0;
        setCoord(new Pair<>(r, c));
        dir = 0;
    }

    public void setCoord(Pair<Integer, Integer> coord) {
        this.coord = coord;
    }

    public Pair nextCoord () {
        Pair<Integer, Integer> nextCoord = null;
        if (dir == 0) {
            nextCoord = new Pair<>(this.coord.fst -1, this.coord.snd);
        } else if (dir == 1) {
            nextCoord = new Pair<>(this.coord.fst, this.coord.snd+1);
        } else if (dir == 2) {
            nextCoord = new Pair<>(this.coord.fst + 1, this.coord.snd);
        } else if (dir == 3) {
            nextCoord = new Pair<>(this.coord.fst, this.coord.snd -1);
        }
        return nextCoord;
    }

    public boolean checkNextCoord (Pair<Integer, Integer> nextCoord, int[][] office) {
        if (nextCoord.fst <0 || nextCoord.fst >= office[0].length ||
                nextCoord.snd <0 || nextCoord.snd >= office[0].length ) {
            return false;
        }
        if (office[nextCoord.fst][nextCoord.snd] == -1) {
            return false;
        }
        return true;
    }

    public void operate (String order) {
        switch (order) {
            case "go" :
                Pair<Integer, Integer> nextCoord = nextCoord();
                if (checkNextCoord(nextCoord, board)) {
                    setCoord(nextCoord);
                }
                break;
            case "right":
                dir = (dir+1)%4 ;
                break;
            case "left":
                dir = (dir-1)%4 ;
                break;
        }
    }

    public void clean () {
        totalCleaning += board[coord.fst][coord.snd];
        board[coord.fst][coord.snd] = 0;
    }
}