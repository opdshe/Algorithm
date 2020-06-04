package programmers.etc;

public class 타일링 {
    public static void main(String[] args) {
        solution(12);
    }

    public static int solution(int n) {
        int maxColumn = n / 2;
        int maxRow = n;
        long count = 0;
        for (int countOfColumn = 0; countOfColumn <= maxColumn; countOfColumn++) {
            for (int countOfRow = 0; countOfRow <= maxRow; countOfRow++) {
                if (countOfColumn * 2 + countOfRow == n) {
                    count += getPermutationWithRepetition(countOfColumn, countOfRow);
                }
            }
        }
        long answer = count % 1000000007;
        System.out.println(answer);
        return (int)answer;
    }

    private static long getPermutationWithRepetition(int countOfColumn, int countOfRow) {
        long sumFactorial = getFactorial(countOfColumn + countOfRow);
        long columnFactorial;
        long rowFactorial;
        if(countOfColumn == 0) {
            columnFactorial =1;
        } else{
            columnFactorial = getFactorial(countOfColumn);
        }
        if(countOfRow == 0) {
            rowFactorial =1;
        } else{
            rowFactorial = getFactorial(countOfRow);
        }
        System.out.println("sumFac = " + sumFactorial);
        return sumFactorial / (rowFactorial * columnFactorial);
    }

    private static long getFactorial(int n) {
        if (n <=1) {
            return 1;
        }else{
            return getFactorial(n - 1) * n;
        }
    }
}
