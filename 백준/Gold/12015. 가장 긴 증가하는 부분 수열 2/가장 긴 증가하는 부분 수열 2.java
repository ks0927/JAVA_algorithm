import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			
			int temp = Arrays.binarySearch(dp, 0, size, arr[i]);
			if(temp >= 0) continue; //중복처리 
			int pos = Math.abs(temp) - 1;

			dp[pos] = arr[i];
			
			if(pos == size) ++size;
			
		}
		
		System.out.println(size);
		
	}

}
