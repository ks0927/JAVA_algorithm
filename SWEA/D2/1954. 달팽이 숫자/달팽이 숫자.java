import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Solution {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] map;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			makeSnail(N, i + 1);
			
			sb.append("#").append(i+1).append("\n");
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					sb.append(map[j][j2]).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void makeSnail(int N, int index) {
		int r = 0;
		int c = -1;

		int flag = 0;
		int cnt = 0;
		
		while(cnt < N*N) {
			int nr = r + dr[flag];
			int nc = c + dc[flag];
			
			if(turnCheck(nr,nc)) {
				flag = (flag + 1) % 4;
				continue;
			}
			cnt++;
			map[nr][nc] = cnt;
			r = nr;
			c = nc;
		}
	}

	private static boolean turnCheck(int r, int c) {
		if (!(r >= 0 && r < N && c >= 0 && c < N) || map[r][c] != 0) {
			return true;
		}
		return false;
	}

}
