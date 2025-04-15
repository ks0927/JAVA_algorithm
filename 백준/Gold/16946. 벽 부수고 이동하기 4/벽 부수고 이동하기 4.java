import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static HashMap<Integer, Integer> sum;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		sum = new HashMap<>();
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dp[i][j] == 0 && map[i][j] == 0) {
					sum.put(cnt, bfs(i, j, cnt));
					cnt++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					
					long result = 1;
					
					ArrayList<Integer> a = new ArrayList<>();
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];

						if (!check(nr, nc))
							continue;
						
						if(map[nr][nc] == 0 && !a.contains(dp[nr][nc])) {
							result += sum.get(dp[nr][nc]);
							a.add(dp[nr][nc]);
						}
					}
					sb.append(result%10);
				}else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	private static int bfs(int i, int j, int cnt) {

		int sum = 1;
		Queue<int[]> queue = new ArrayDeque();
		queue.add(new int[] { i, j });
		dp[i][j] = cnt;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int r = poll[0];
			int c = poll[1];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 0 && dp[nr][nc] == 0) {
					dp[nr][nc] = cnt;
					sum += 1;
					queue.add(new int[] {nr,nc});
				}
			}
		}

		return sum;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
