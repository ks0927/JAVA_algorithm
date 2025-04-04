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
		dp[0] = 1;
		
		for (int i = 0; i < N; i++) {
			int now = coins[i];
			if(now > K) continue;
			for (int j = now; j <= K; j++) {
				dp[j] = dp[j] + dp[j - now];
			}
		}
		
		System.out.println(dp[K]);
	}

}
