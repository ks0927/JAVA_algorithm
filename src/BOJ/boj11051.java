package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11051 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Long[][] memo = new Long[1001][1001];

        memo[1][0] = 1L;
        memo[1][1] = 1L;

        for (int n = 2; n <= 1000; n++) {
            for (int k = 0; k <= n; k++) {

                if(k == 0){
                    memo[n][k] = 1L;
                    continue;
                }
                if(k == n){
                    memo[n][k] = 1L;
                    continue;
                }

                Long L1 = memo[n - 1][k - 1] % 10007;
                Long L2 = memo[n - 1][k] % 10007;
                Long nowValue = (L1 + L2) % 10007;

                memo[n][k] = nowValue;
            }
        }

        System.out.println(memo[N][K]);

    }
}
