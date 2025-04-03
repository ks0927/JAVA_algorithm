import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new long[3][N][N];

		dp[0][0][1] = 1;
		for (int i = 2; i < N; i++) {
			if(map[0][i] == 1) break;
			dp[0][0][i] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {
				
				if(checkG(i,j)) {
					dp[0][i][j] = dp[2][i][j - 1] + dp[0][i][j - 1];
				}
				
				if(checkS(i,j)) {
					dp[1][i][j] = dp[2][i - 1][j] + dp[1][i - 1][j];
				}
				
				if(checkD(i,j)) {
					dp[2][i][j] = dp[2][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[0][i - 1][j - 1];
				}
			}
		}
		
		System.out.println(dp[2][N - 1][N - 1] + dp[1][N - 1][N - 1] + dp[0][N - 1][N - 1]);
	}

	private static boolean checkG(int i, int j) {
		if(map[i][j] == 1) return false;
		if(map[i][j-1] == 1) return false;
		return true;
	}

	private static boolean checkS(int i, int j) {
		if(map[i][j] == 1) return false;
		if(map[i-1][j] == 1) return false;
		return true;
	}
	
	private static boolean checkD(int i, int j) {
		if(map[i][j] == 1) return false;
		if(map[i][j-1] == 1) return false;
		if(map[i-1][j] == 1) return false;
		if(map[i-1][j-1] == 1) return false;
		return true;
	}
}
