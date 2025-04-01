import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];
		boolean check = false; // 1xN 또는 MxN 인경우  max값 위한 체크
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value == 0) {
					dp[i][j] = 1;
					check = true; //1xN 또는 MxN일때 땅이 있음
				}else {
					dp[i][j] = -1;
				}
			}
		}
		int max = 0;
		
		if(N == 1 || M == 1) { // 둘중 하나가 1이면 아래 이중포문 로직에 들어가질 않아서 체크해줘야함
			if(check) max = 1;
		}
		
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if(dp[i][j] == -1) continue;
				
				if(dp[i][j-1] != -1 && dp[i-1][j] != -1 && dp[i-1][j-1] != -1) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(max);

	}

}
