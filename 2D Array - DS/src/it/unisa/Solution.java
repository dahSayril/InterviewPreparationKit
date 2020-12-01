package it.unisa;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int max = -63;
        int top, bottom, hourglass;
        
        for(int i = 0; i < 4; i++) {
            for(int y = 0; y < 4; y++) {
                top = arr[i][y] + arr[i][y + 1] + arr[i][y + 2];
                System.out.println("Top is: " + arr[i][y] + " " + arr[i][y + 1] + " " + arr[i][y + 2]);
                bottom = arr[i + 2][y] + arr[i + 2][y + 1] + arr[i + 2][y + 2];
                System.out.println("Bottom is: " + arr[i + 2][y] + " " + arr[i + 2][y + 1] + " " + arr[i + 2][y + 2]);
                hourglass = top + bottom + arr[i + 1][y + 1];
                System.out.println("Center is: " + arr[i + 1][y + 1]);
                max = Math.max(max, hourglass);
                System.out.println("Hourglass value: " + hourglass);
                System.out.println("Now max is: " + max);
                        
            }
        
        }
        
        return max;

    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
