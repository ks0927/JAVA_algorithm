package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj2294 {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> coins = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int coin = Integer.parseInt(st.nextToken());
            coins.add(coin);
        }

        int[] dp = new int[K+1];

        Arrays.fill(dp,10001);
        dp[0] = 0;

        for (Integer coin : coins) {
            for (int i = coin; i <= K; i++) {
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }

        if(dp[K] == 10001){
            System.out.println(-1);
        }
        else {
            System.out.println(dp[K]);
        }

    }
}
