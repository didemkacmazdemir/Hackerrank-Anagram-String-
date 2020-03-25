import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
int n = s.length();
        if (n % 2 != 0)
            return -1;
        int[] hash = new int[250];
        Arrays.fill(hash, 0);
        for (int i = n / 2; i < n; i++) //ikinci string array de olan karakterlerin ascii kodlarına gore sayısını bul
            hash[(int) s.charAt(i)]++;
        for (int i = 0; i < n / 2; i++) // ilk strig array de bulunan karakterlerin ascii kodlarını bul
            hash[(int) s.charAt(i)]--;

        int cnt = 0;
        for (int i = 0; i < 250; i++) // - olanlar ilk yarı, + lar ikinci yarı. İlk array de bulunması gerekenler + olmalı
            if (hash[i] > 0)
                cnt += hash[i];
        return cnt;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
