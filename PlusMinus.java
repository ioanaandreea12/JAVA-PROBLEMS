
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int countminus =0;
        int countplu=0;
        int countzero=0;
        for(int i=0;i<arr.length;i++)
        {
                if(arr[i]>0)
                {
                        countplu++;
                }
                if(arr[i]<0)
                {
                    countminus++;

                }
            if(arr[i]==0)
            {
                countzero++;

            }
        
        }
        System.out.println((float)(countplu)/(float)(arr.length));
          System.out.println((float)(countminus)/(float)(arr.length));
          System.out.println((float)(countzero)/(float)(arr.length));
        


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
