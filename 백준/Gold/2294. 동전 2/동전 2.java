import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		int[] dp = new int[K + 1];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
//		Arrays.sort(coins);

		Arrays.fill(dp, 10000001);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			int now = coins[i];
			if(now > K) continue;
			dp[now] = 1;
			for (int j = now + 1; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j - now] + 1);
			}
		}
		
		System.out.println(dp[K] == 10000001 ? -1 : dp[K]);
	}

}
