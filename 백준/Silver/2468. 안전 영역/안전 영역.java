import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int safe;
	static int max;
	static int maxHeight = 0;
	static int[][] map;
	static int[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				maxHeight = Math.max(value, maxHeight);
			}
		}

		max = 0;
		for (int rain = 0; rain < maxHeight; rain++) {
			safe = 0;
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0 && map[i][j] - rain > 0){
						safe++;
						BFS(i, j, rain);
					}
				}
			}

			max = Math.max(safe, max);
		}

		System.out.println(max);
	}

	public static void BFS(int cr, int cc, int rain) {

		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { cr, cc });
		visited[cr][cc] = safe;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] - rain > 0 && visited[nr][nc] == 0) {
					que.offer(new int[] { nr, nc });
					visited[nr][nc] = safe;
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
