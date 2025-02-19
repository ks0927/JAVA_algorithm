import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int babyR;
	static int babyC;
	static int count;
	static int babySize;
	static int eat;
	static int time;
	static int[][] map;
	static boolean helpMom;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] != 0 && map[i][j] != 9) {
					count++;
				}
				if (map[i][j] == 9) {
					babyR = i;
					babyC = j;
				}
			}
		}

		map[babyR][babyC] = 0;
		time = 0;
		babySize = 2;
		eat = 0;
		helpMom = false;
		while (true) {
			if (count == 0 || helpMom)
				break;
			visited = new boolean[N][N];
			bfs(babyR, babyC);
		}

		System.out.println(time);
	}

	private static void bfs(int rr, int cc) {

		// 먹을 수 있으면 끝
		if (map[rr][cc] != 0 && map[rr][cc] < babySize) {
			eat++;
			count--;
			if (eat == babySize) {
				babySize++;
				eat = 0;
			}
			map[rr][cc] = 0;
			return;
		}

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { rr, cc });
		visited[rr][cc] = true;

		// 먹을 수 있는거 찾기
		int level = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();
			level++;

			int bestR = N + 1;
			int bestC = N + 1;
			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();
				int tr = poll[0];
				int tc = poll[1];

				for (int j = 0; j < 4; j++) {
					int nr = tr + dr[j];
					int nc = tc + dc[j];

					if (!check(nr, nc))
						continue;

					if (visited[nr][nc])
						continue;

					if (map[nr][nc] > babySize)
						continue;

					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
					// 먹을 수 있으면 끝
					if (map[nr][nc] != 0 && map[nr][nc] < babySize) {
						if (nr < bestR) {
							bestR = nr;
							bestC = nc;
						} else if (nr == bestR) {
							if (nc < bestC) {
								bestR = nr;
								bestC = nc;
							}
						}
					}

				}
			}

			// 먹을 수 있으면 끝
			if(bestR != N+1 && bestC != N+1) {
				if (map[bestR][bestC] != 0 && map[bestR][bestC] < babySize) {
					time += level;
					eat++;
					count--;
					if (eat == babySize) {
						babySize++;
						eat = 0;
					}
					babyR = bestR;
					babyC = bestC;
					map[bestR][bestC] = 0;
					return;
				}
			}


		}
		helpMom = true;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
