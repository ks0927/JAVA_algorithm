package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj9465 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] stickers = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    int a = Integer.parseInt(st.nextToken());
                    stickers[j][k] = a;
                }
            }

            // 초기값 세팅
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            // dp[0] 일땐 왼쪽아래값과 왼왼쪽아래값을 비교한뒤 더한다.
            // dp[1] 일땐 왼쪽위값과 왼왼쪽위값을 비교한뒤 더한다.
            for (int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + stickers[1][j];
            }

            int asInt0 = Arrays.stream(dp[0]).max().getAsInt();
            int asInt1 = Arrays.stream(dp[1]).max().getAsInt();
            int max = Math.max(asInt0, asInt1);
            System.out.println(max);
        }

    }
}
