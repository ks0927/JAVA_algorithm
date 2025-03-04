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

		int[] dp = new int[N + 1];
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			
			max = Math.max(max, dp[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(max);
	}

}
