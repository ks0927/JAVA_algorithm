import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] weights;
	static int[] profits;

	static int[] dp;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		weights = new int[N + 1];
		profits = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			weights[i] = w;
			profits[i] = p;
		}

		dp = new int[K+1];
		
		for (int i = 1; i <= N; i++) {
			int w = weights[i];
			int p = profits[i];

			for (int j = K; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j - w] + p);
			}
			
		}
		
		System.out.println(dp[K]);
		
	}

}
