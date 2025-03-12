import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[i][0] = r;
            map[i][1] = g;
            map[i][2] = v;
        }

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + map[i][2];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min,dp[N-1][i]);
        }
        System.out.println(min);
    }


}