package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int coin = Integer.parseInt(st.nextToken());
            coins[i] = coin;
        }

        int[] dp = new int[K+1];

        //0을 1로 두는이유는 동전1원일때 1원으로 만들수있는경우 +1, 3원일때 3원으로 만들수있는경우 +1 ...이렇게 나타려고
        dp[0] = 1;
        for (int i = 0; i < N; i++) {

            int nowCoin = coins[i];

            for (int j = nowCoin; j <= K; j++) {
                int nowDpValue = dp[j];

                int preValueIndex = j - nowCoin;

                //혹시 범위를 벗어 난다면 pass
                if(!(0<=preValueIndex && preValueIndex<=K)){
                    continue;
                }

                dp[j] = dp[preValueIndex] + nowDpValue;
            }

/*            System.out.println("i = " + i);
            for (int j = 0; j < dp.length; j++) {
                System.out.println("dp["+j+"] = " + dp[j]);
            }*/
        }
        System.out.println(dp[K]);
    }
}
