import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= 40; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		int now = 1;

		long sum = 1;
		for (int i = 0; i < M; i++) {
			int index = Integer.parseInt(br.readLine());

			sum *= dp[index - now];
			now = index+1;
		}
		
		if(now != N+1) {
			sum *= dp[N+1 - now];
		}
		
		System.out.println(sum);
	}

}
