import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		int[] path = new int[N+1];
		
		Arrays.fill(dp, 1000001);
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			if(dp[i] > dp[i-1] + 1) {
				dp[i] = dp[i-1] + 1;
				path[i] = i-1;
			}
			
			if(i%2 == 0) {
				if(dp[i] > dp[i/2] + 1) {
					dp[i] = dp[i/2] + 1;
					path[i] = i/2;
				}
			}
			
			if(i%3 == 0) {
				if(dp[i] > dp[i/3] + 1) {
					dp[i] = dp[i/3] + 1;
					path[i] = i/3;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		
		sb.append(dp[N]).append("\n");
		
		int root = N;
		
		while(root != 0) {
			sb.append(root).append(" ");
			root = path[root];
		}
		
		System.out.println(sb);
	}

}
