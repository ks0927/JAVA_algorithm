import java.util.*;
import java.io.*;

public class Main {
	static int M;
	static int N;
	static int cnt;
	static int[][] map;
	static int[][] visited;
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, 1, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 0));

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(visited[i][j]+"\t");
//			}
//			System.out.println();
//		}
	}

	private static int dfs(int r, int c) {

		if (r == N - 1 && c == M - 1) {
			return 1;
		}

		if (visited[r][c] != -1) {
			return visited[r][c];
		}

		visited[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (!check(nr, nc))
				continue;

			if (map[r][c] > map[nr][nc]) {
				visited[r][c] += dfs(nr,nc);
			}

		}

		return visited[r][c];
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
