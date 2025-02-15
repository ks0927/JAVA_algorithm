import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N = 200;
	static int x1, x2, y1, y2;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			visited = new int[N + 1][N + 1][2];
			Queue<int[]> que = new LinkedList<int[]>();
			que.offer(new int[] { x1, y1, 0, 0 }); // 거리 0 , 방향 0
			que.offer(new int[] { x1, y1, 0, 1 }); // 거리 0 , 방향 0

			visited[x1][y1][0] = 1;
			visited[x1][y1][1] = 1;
			int value = -1;

			while (!que.isEmpty()) {
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				int dir = cur[3];

				if (r == x2 && c == y2) {
					value = cnt;
					break;
				}

				for (int d = 1; d < 4; d += 2) {
					int s = (dir + d) % 4; // 1 + 0 => 1
					int u = (dir + d) % 2;
					int nr = r + dr[s];
					int nc = c + dc[s];

					if (!check(nr, nc))
						continue;

					if (visited[nr][nc][u] == 0) {
						visited[nr][nc][u] = 1;
						que.offer(new int[] { nr, nc, cnt + 1, u });
					}
				}
			}

			System.out.println("#" + (i + 1) + " " + value);
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N + 1 && c >= 0 && c < N + 1;
	}

}
