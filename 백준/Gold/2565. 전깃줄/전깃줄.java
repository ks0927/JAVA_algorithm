import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[501];
		int size = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map[s] = e;
			size = Math.max(size, s);
		}

		int[] dp = new int[size + 1];
		
		int result = 0;
		for (int i = 1; i <= size ; i++) {
			if(map[i] == 0) continue;
			
			dp[i] = 1;
			
			int max = 0;
			for (int j = 1; j < i; j++) {
				if(map[j] < map[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
			
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(N - result);
	}

}
