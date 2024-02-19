import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 1) {
                    dp[1][j] = 1;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %=  1_000_000_000;
            }
        }

        System.out.println(dp[M][N]);
    }
}
