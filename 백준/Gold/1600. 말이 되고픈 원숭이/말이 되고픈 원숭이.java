import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dr2 = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dc2 = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int K;
	static int W;
	static int H;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] visited = new int[H][W][K + 1];//3차원 [K + 1]은 남은 나이트이동횟수를 의미

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 0, K }); // r,c,cnt,말이동가능횟수
		visited[0][0][K] = 1;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int tr = poll[0];
			int tc = poll[1];
			int cnt = poll[2];
			int canMove = poll[3];

			if (tr == H - 1 && tc == W - 1) {
				System.out.println(cnt);
				return;
			}

			// 4방 이동
			for (int i = 0; i < 4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 1)
					continue;

				if (visited[nr][nc][canMove] == 0) {
					visited[nr][nc][canMove] = 1;
					queue.add(new int[] { nr, nc, cnt + 1, canMove });
				}
			}

			// 나이트 이동
			for (int i = 0; i < 8; i++) {
				
				if(canMove <= 0) break; //나이트 이동횟수가 없다면 못함
				
				int nr = tr + dr2[i];
				int nc = tc + dc2[i];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 1)
					continue;

				if (visited[nr][nc][canMove - 1] == 0) {
					visited[nr][nc][canMove - 1] = 1;
					queue.add(new int[] { nr, nc, cnt + 1, canMove -1 });
				}
			}
		}
		
		System.out.println(-1);

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

}
