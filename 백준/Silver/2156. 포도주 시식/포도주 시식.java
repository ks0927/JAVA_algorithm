import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] wine;
    static int[] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        wine = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }

        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        int max = dp[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + wine[i - 1]) + wine[i], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }


}