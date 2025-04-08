import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dp = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = arr[i];
			
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i],dp[j] + arr[i]);
				}
			}
			
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}

}
