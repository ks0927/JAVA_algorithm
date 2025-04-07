import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] weights;
	static int[] profits;

	static int[][] dp;
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

		dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				
				if(weights[i] <= j) { // j인 가방 보다 내 무게가 작거나 같을때는 넣어봐야지
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + profits[i]);
				}else { // j인가방 보다 내 무게가 크면 아예 못넣으니까 이전값 가져와야지
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
		
	}

}
