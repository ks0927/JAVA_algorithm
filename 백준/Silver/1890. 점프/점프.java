import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				long value = dp[i][j];
				if (value != 0) {

					if(i== N-1 && j == N-1) continue;
					
					int v = map[i][j];

					move1(i, j, v);
					move2(i, j, v);
				}
			}
			
		}



		System.out.println(dp[N - 1][N - 1]);

	}

	private static void move1(int i, int j, int v) {
		int r = i;
		int c = j + v;
		if (!check(r, c))
			return;
		dp[r][c] += dp[i][j];

	}

	private static void move2(int i, int j, int v) {
		int r = i + v;
		int c = j;
		if (!check(r, c))
			return;
		dp[r][c] += dp[i][j];

	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}