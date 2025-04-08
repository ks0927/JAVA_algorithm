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
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			
			int max = 0;
			for (int j = 0; j < i; j++) {
				
				if(arr[j] > arr[i]) {
					max = Math.max(max, dp[j]); 
				}
			}
			dp[i] = max + 1;
			
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);

	}

}
