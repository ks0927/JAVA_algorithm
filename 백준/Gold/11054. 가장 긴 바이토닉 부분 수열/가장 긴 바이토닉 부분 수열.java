import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp  = new int[N];
		
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				
				if(arr[j] < arr[i]) {
					max = Math.max(max, dp[j]); 
				}
			}
			dp[i] = max + 1;
			
		}
//		System.out.println(Arrays.toString(dp));
		

		int[] dp2  = new int[N];
		
		for (int i = N-1; i >= 0; i--) {
			int max = 0;
			for (int j = N-1; j > i; j--) {
				
				if(arr[j] < arr[i]) {
					max = Math.max(max, dp2[j]); 
				}
			}
			dp2[i] = max + 1;
		}
//		System.out.println(Arrays.toString(dp2));

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dp[i] + dp2[i] - 1);
		}
		
		System.out.println(result);
	}

}
