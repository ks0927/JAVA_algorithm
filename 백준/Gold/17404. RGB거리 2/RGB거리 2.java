import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static final int MAX = 1_000_001;
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

        int min = Integer.MAX_VALUE;

        // 첫집을 빨강 -> 초록,파랑 = 1000001  // 마지막을 초록과 파랑만 고름
        dp[0][0] = map[0][0];
        dp[0][1] = MAX;
        dp[0][2] = MAX;
        for (int i = 1; i < N - 1; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
        }
        dp[N-1][0] = MAX;
        dp[N-1][1] = Math.min(dp[N - 2][0], dp[N - 2][2]) + map[N-1][1];
        dp[N-1][2] = Math.min(dp[N - 2][0], dp[N - 2][1]) + map[N-1][2];

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }

        // 첫집을 초록 -> 빨강,파랑 = 1000001  // 마지막을 빨강과 파랑만 고름
        dp[0][0] = MAX;
        dp[0][1] = map[0][1];
        dp[0][2] = MAX;
        for (int i = 1; i < N - 1; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
        }
        dp[N-1][0] = Math.min(dp[N - 2][1], dp[N - 2][2]) + map[N-1][0];
        dp[N-1][1] = MAX;
        dp[N-1][2] = Math.min(dp[N - 2][0], dp[N - 2][1]) + map[N-1][2];

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }

        // 첫집을 파랑 -> 빨강,초록 = 1000001  // 마지막을 빨강과 초록만 고름
        dp[0][0] = MAX;
        dp[0][1] = MAX;
        dp[0][2] = map[0][2];
        for (int i = 1; i < N - 1; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
        }
        dp[N-1][0] = Math.min(dp[N - 2][1], dp[N - 2][2]) + map[N-1][0];
        dp[N-1][1] = Math.min(dp[N - 2][0], dp[N - 2][2]) + map[N-1][1];
        dp[N-1][2] = MAX;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }

        System.out.println(min);
    }


}