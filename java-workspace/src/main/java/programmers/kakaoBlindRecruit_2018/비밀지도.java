package programmers.kakaoBlindRecruit_2018;

public class 비밀지도 {
    public static void main(String[] args) {
        solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map1 = makeMap(n, arr1);
        int[][] map2 = makeMap(n, arr2);
        String[] answer = createCorrectMamp(n, map1, map2);
        for(String string : answer) {
            System.out.println(string);
        }
        return answer;
    }

    private static int[][] makeMap(int n, int[] arr) {
        int[][] map = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            String binary = Integer.toBinaryString(arr[i]);
            while (!checkDigit(n, binary)) {
                binary = addZero(binary);
            }
            for (int j = 0; j < n; j++) {
                if (binary.charAt(j) == '0') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        return map;
    }

    private static boolean checkDigit(int n, String binary) {
        return binary.length() == n;
    }

    private static String addZero(String binary) {
        return "0" + binary;
    }

    private static String[] createCorrectMamp(int n, int[][] map1, int[][] map2) {
        String[] correctMap = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (map1[i][j] + map2[i][j] > 0) {
                    stringBuilder.append("#");
                } else {
                    stringBuilder.append(" ");
                }
            }
            correctMap[i] = stringBuilder.toString();
        }
        return correctMap;
    }
}
