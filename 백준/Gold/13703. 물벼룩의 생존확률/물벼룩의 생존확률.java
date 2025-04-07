import java.io.*;
import java.util.*;

public class Main {

    static int N, K;

    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][K + N + 1];

        dp[0][K] = 1;

        if(K == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < K + N + 1; j++) {
                if (dp[i][j] != 0) {
                    int left = j - 1;
                    int right = j + 1;

                    if (left > 0) {
                        dp[i + 1][left] += dp[i][j];
                    }
                    dp[i + 1][right] += dp[i][j];
                }
            }

        }

        long sum = 0;
        for (int i = 1; i < K + N + 1; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum);

    }
}
