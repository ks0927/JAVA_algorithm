import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[501];
		int limit = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map[s] = e;
			limit = Math.max(limit, s);
		}

		int[] dp = new int[limit + 1];
		
		int result = 0;
		int size = 1;
		for (int i = 1; i <= limit ; i++) {
			if(map[i] == 0) continue;
			
			int temp = Arrays.binarySearch(dp, 1,size,map[i]);
			
			int pos = Math.abs(temp) - 1;
			dp[pos] = map[i];
			if(pos == size) ++size;
			
		}
		System.out.println(N - size + 1);
	}

}
