import java.util.*;
import java.io.*;

public class Main {

	static int MOD = 1_000_000_000;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][10];
		
		for (int i = 1; i <= 9 ; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < 9; j++) {
				dp[i+1][j-1] = (dp[i+1][j-1] + dp[i][j]) % MOD;
				dp[i+1][j+1] = (dp[i+1][j+1] + dp[i][j]) % MOD;
			}
			dp[i+1][1] =(dp[i+1][1] + dp[i][0]) % MOD;
			dp[i+1][8] =(dp[i+1][8] + dp[i][9]) % MOD;
		}
		
		long result = 0;
		for (int i = 0; i < 10; i++) {
			result =(result + dp[N][i])% MOD;
		}
		System.out.println(result);
		
/*		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += dp[i][j];
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("sum = ["+sum+"]");
		}*/
	}

}
