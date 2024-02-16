import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                map[i][j] = parseInt;
            }
        }

        dp[0][0] = map[0][0];

        if (N == 1) {
            System.out.println(dp[0][0]);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i+1][j] = Math.max(dp[i][j] + map[i+1][j],dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j] + map[i+1][j+1],dp[i+1][j+1]);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if(result < dp[N-1][i])
                result = dp[N-1][i];
        }

        System.out.println(result);
    }
}
