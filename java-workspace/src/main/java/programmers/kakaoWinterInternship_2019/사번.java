package programmers.kakaoWinterInternship_2019;

import java.util.ArrayList;
import java.util.List;

public class 사번 {
    static boolean[][] visited;
    static int[][] myBoard;
    static int answer;

    public static void main(String[] args) {
        solution(new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}});
    }

    public static int solution(int[][] board) {
        init(board);
        List<String> dir= new ArrayList<>();
        dfs(0, 0, dir);
        return answer;
    }

    public static void init(int[][] board) {
        myBoard = board;
        visited = new boolean[board.length][board.length];
        answer = 500 * myBoard.length*myBoard.length;
    }

    public static void dfs(int r, int c, List<String> dir) {
        if (r == myBoard.length - 1 && c == myBoard.length - 1) {
            answer = Math.min(answer, getPrice(dir));
            return;
        }
        visited[r][c] = true;
        List<String> newString = new ArrayList<>();
        int nextR = r;
        int nextC = c + 1;
        if (checkRange(nextR, nextC)) {
            if (myBoard[nextR][nextC] == 0) {
                newString = new ArrayList<>(dir);
                newString.add("hor");
                dfs(nextR, nextC, newString);
            }
        }
        nextR = r;
        nextC = c - 1;
        if (checkRange(nextR, nextC)) {
            if (myBoard[nextR][nextC] == 0) {
                newString = new ArrayList<>(dir);
                newString.add("hor");
                dfs(nextR, nextC, newString);
            }
        }
        nextR = r + 1;
        nextC = c;
        if (checkRange(nextR, nextC)) {
            if (myBoard[nextR][nextC] == 0) {
                newString = new ArrayList<>(dir);
                newString.add("ver");
                dfs(nextR, nextC, newString);
            }
        }
        nextR = r - 1;
        nextC = c;
        if (checkRange(nextR, nextC)) {
            if (myBoard[nextR][nextC] == 0) {
                newString = new ArrayList<>(dir);
                newString.add("ver");
                dfs(nextR, nextC, newString);
            }
        }
        visited[r][c] = false;
    }
    public static boolean checkRange(int r, int c) {
        return r >= 0 && r < myBoard.length && c >= 0 && c < myBoard.length && !visited[r][c];
    }

    public static int getPrice (List<String> dir) {
        int straight = 0;
        int curve = 0;
        String curr = dir.remove(0);
        while (!dir.isEmpty()) {
            String next = dir.remove(0);
            straight+=1;
            if (!curr.equals(next)) {
                curve += 1;
            }
            curr = next;
        }
        return (straight+1)*100 + curve*500;
    }

}
