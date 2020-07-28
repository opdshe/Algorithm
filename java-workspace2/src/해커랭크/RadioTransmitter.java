package 해커랭크;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RadioTransmitter {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        int answer = 0;
        int currentIdx = 0;
        if (x[currentIdx] + k >= x[currentIdx+1]) {
            currentIdx++;
        } else {

            answer++;
        }

            return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = "8 2".split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = "7 2 4 6 5 9 12 11".split(" ");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
    }
}
