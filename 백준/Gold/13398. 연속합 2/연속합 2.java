import java.io.*;
import java.util.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[] nums = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}



		int[][] dp = new int[2][N + 1];

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			dp[1][i] = Math.max(dp[1][i - 1] + nums[i], nums[i]);
			dp[0][i] = Math.max(Math.max(dp[0][i - 1] + nums[i], dp[1][i - 1]), nums[i]);
			
			if(i == 1) {
				dp[0][1] = nums[i];
			}
			max = Math.max(Math.max(max, dp[0][i]), dp[1][i]);
		}

//		System.out.println(Arrays.toString(dp[0]));
//		System.out.println(Arrays.toString(dp[1]));
		System.out.println(max);
	}

}
