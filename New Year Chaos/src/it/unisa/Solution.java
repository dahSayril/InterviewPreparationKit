package it.unisa;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int[] chaotic = new int[q.length];
        int nSwap = 0;
        int j, k;

        for(int i = 1; i < q.length; i++) {
            for(j = i - 1; q[j] != i; j++) ;
            if(j != i - 1) {
                for(k = j; k >= i; k--) {
                    q[k] = q[k - 1];
                    chaotic[q[k] - 1]++;
                    nSwap++;
                    if(chaotic[q[k] - 1] == 3) {
                        System.out.println("Too chaotic");
                        return;
                    }
                }
                q[i - 1] = i;
            }
        }
              
        System.out.println(nSwap);
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
