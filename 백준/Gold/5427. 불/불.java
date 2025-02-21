import java.io.*;
import java.util.*;

public class Main {

	static int C;
	static int R;
	static int time;
	static int[][] map;
	static Queue<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];

			queue = new LinkedList();

			int curR = 0;
			int curC = 0;
			for (int j = 0; j < R; j++) {
				String str = br.readLine();

				for (int j2 = 0; j2 < C; j2++) {
					if (str.charAt(j2) == '#') {
						map[j][j2] = -1;
					}

					if (str.charAt(j2) == '@') {
						map[j][j2] = 1;
						curR = j;
						curC = j2;
					}

					// 불
					if (str.charAt(j2) == '*') {
						map[j][j2] = 2;
						queue.add(new int[] { j, j2, 2 });
					}
				}
			}

			// 상근이
			queue.add(new int[] { curR, curC, 1 });
			time = 0;
			bfs();
			sb.append((time == 0) ? "IMPOSSIBLE" : time).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			int humanCount = 0; // 상근이가 이동하는지 체크
			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();
				int r = poll[0];
				int c = poll[1];
				int what = poll[2];

				// 불일때
				if (what == 2) {

					for (int j = 0; j < 4; j++) {
						int nr = r + dr[j];
						int nc = c + dc[j];

						if (!check(nr, nc))
							continue;

						if (map[nr][nc] == -1)
							continue;
						if (map[nr][nc] == 2)
							continue;

						map[nr][nc] = 2;
						queue.add(new int[] { nr, nc, 2 });
					}
				}

				// 상근이일때
				if (what == 1) {
					humanCount++;
					for (int j = 0; j < 4; j++) {
						int nr = r + dr[j];
						int nc = c + dc[j];

						// 탈출
						if (!check(nr, nc)) {
							time = level;
							return;
						}

						if (map[nr][nc] == -1)
							continue;
						if (map[nr][nc] == 2)
							continue;
						if (map[nr][nc] == 1)
							continue;

						map[nr][nc] = 1;
						queue.add(new int[] { nr, nc, 1 });
					}
				}
			}
			
			//큐에 상근이가 없다면 이미 사망했거나 움직일 곳이없음.
			if(humanCount == 0) 
				return;
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
