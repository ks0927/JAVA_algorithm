import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int N, M;
	static int[][] visited;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
			}
		}

		int level = 0;
		while (true) {

			// 분리된 빙산 찾기
			boolean[][] connect = new boolean[N][M];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					if (map[i][j] != 0 && !connect[i][j]) {
						cnt++;

						Queue<int[]> queue = new ArrayDeque<int[]>();
						queue.add(new int[] { i, j });
						connect[i][j] = true;

						while (!queue.isEmpty()) {

							int[] poll = queue.poll();
							int r = poll[0];
							int c = poll[1];
							for (int k = 0; k < 4; k++) {
								int nr = r + dr[k];
								int nc = c + dc[k];

								if (!check(nr, nc))
									continue;

								if (map[nr][nc] != 0 && !connect[nr][nc]) {
									connect[nr][nc] = true;
									queue.add(new int[] { nr, nc });
								}
							}
						}
					}
				}
			}
			
			// 빙산이 2조각이상
			if(cnt > 1) {
				System.out.println(level);
				return;
			}
			
			// 빙산이 아예없거나 한번에 다녹음
			if(cnt == 0) {
				System.out.println(0);
				return;
			}

			// 빙산 녹이기
			visited = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						calculate(i, j);
					}
				}
			}

			// 복사
			for (int i = 0; i < N; i++) {
				map[i] = visited[i].clone();
			}

			level++;
		}
	}

	private static void calculate(int r, int c) {

		int minus = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (!check(nr, nc))
				continue;

			if (map[nr][nc] == 0) {
				minus++;
			}
		}

		visited[r][c] = (map[r][c] - minus) >= 0 ? map[r][c] - minus : 0;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
