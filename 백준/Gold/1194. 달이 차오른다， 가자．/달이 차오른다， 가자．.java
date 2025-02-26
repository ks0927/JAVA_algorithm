import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static String[][] map;
	static int[][][] move;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new String[N][M];
		move = new int[N][M][1 << 6];

		for (int i = 0; i < (1 << 6); i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					move[j][j2][i] = Integer.MAX_VALUE;
				}
			}
		}

		int r = 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				String value = String.valueOf(str.charAt(j));
				map[i][j] = value;

				if (value.equals("0")) {
					r = i;
					c = j;
				}
			}
		}

		System.out.println(BFS(r, c));
		System.out.println();
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	private static int BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c, 0, 0 });
		move[r][c][0] = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();

				int tr = poll[0];
				int tc = poll[1];
				int steps = poll[2];
				int keys = poll[3];

				for (int j = 0; j < 4; j++) {
					int nr = tr + dr[j];
					int nc = tc + dc[j];

					if (!check(nr, nc))
						continue;

					String cur = map[nr][nc];

					if (cur.equals("1")) {
						return steps + 1;
					}

					if ((cur.equals(".") || cur.equals("0")) && (move[nr][nc][keys] > steps + 1)) {
						move[nr][nc][keys] = steps + 1;
						queue.add(new int[] { nr, nc, steps + 1, keys });
					}

					if (cur.equals("a")) {
						if(((keys & 1 << 0) == 0)) {
							move[nr][nc][(keys | 1 << 0)] = steps + 1;
							queue.add(new int[] { nr, nc, steps + 1, (keys | 1 << 0) });
						}else {
							if(move[nr][nc][keys] > steps + 1) {
								move[nr][nc][keys] = steps + 1;
								queue.add(new int[] { nr, nc, steps + 1, keys });
							}
						}
					}
					if (cur.equals("b")) {
						if(((keys & 1 << 1) == 0)) {
							move[nr][nc][(keys | 1 << 1)] = steps + 1;
							queue.add(new int[] { nr, nc, steps + 1, (keys | 1 << 1) });
						}else {
							if(move[nr][nc][keys] > steps + 1) {
								move[nr][nc][keys] = steps + 1;
								queue.add(new int[] { nr, nc, steps + 1, keys });
							}
						}
					}
					
					if (cur.equals("c")) {
						if(((keys & 1 << 2) == 0)) {
							move[nr][nc][(keys | 1 << 2)] = steps + 1;
							queue.add(new int[] { nr, nc, steps + 1, (keys | 1 << 2) });
						}else {
							if(move[nr][nc][keys] > steps + 1) {
								move[nr][nc][keys] = steps + 1;
								queue.add(new int[] { nr, nc, steps + 1, keys });
							}
						}
					}

					if (cur.equals("d")) {
						if(((keys & 1 << 3) == 0)) {
							move[nr][nc][(keys | 1 << 3)] = steps + 1;
							queue.add(new int[] { nr, nc, steps + 1, (keys | 1 << 3) });
						}else {
							if(move[nr][nc][keys] > steps + 1) {
								move[nr][nc][keys] = steps + 1;
								queue.add(new int[] { nr, nc, steps + 1, keys });
							}
						}
					}
					
					if (cur.equals("e")) {
						if(((keys & 1 << 4) == 0)) {
							move[nr][nc][(keys | 1 << 4)] = steps + 1;
							queue.add(new int[] { nr, nc, steps + 1, (keys | 1 << 4) });
						}else {
							if(move[nr][nc][keys] > steps + 1) {
								move[nr][nc][keys] = steps + 1;
								queue.add(new int[] { nr, nc, steps + 1, keys });
							}
						}
					}
					
					if (cur.equals("f")) {
						if(((keys & 1 << 5) == 0)) {
							move[nr][nc][(keys | 1 << 5)] = steps + 1;
							queue.add(new int[] { nr, nc, steps + 1, (keys | 1 << 5) });
						}else {
							if(move[nr][nc][keys] > steps + 1) {
								move[nr][nc][keys] = steps + 1;
								queue.add(new int[] { nr, nc, steps + 1, keys });
							}
						}
					}

					if (cur.equals("A") && ((keys & 1 << 0) != 0) && (move[nr][nc][keys] > steps + 1)) {
						move[nr][nc][keys] = steps + 1;
						queue.add(new int[] { nr, nc, steps + 1, keys });
					}
					if (cur.equals("B") && ((keys & 1 << 1) != 0) && (move[nr][nc][keys] > steps + 1)) {
						move[nr][nc][keys] = steps + 1;
						queue.add(new int[] { nr, nc, steps + 1, keys });
					}
					if (cur.equals("C") && ((keys & 1 << 2) != 0) && (move[nr][nc][keys] > steps + 1))  {
						move[nr][nc][keys] = steps + 1;
						queue.add(new int[] { nr, nc, steps + 1, keys });
					}
					if (cur.equals("D") && ((keys & 1 << 3) != 0) && (move[nr][nc][keys] > steps + 1)) {
						move[nr][nc][keys] = steps + 1;
						queue.add(new int[] { nr, nc, steps + 1, keys });
					}
					if (cur.equals("E") && ((keys & 1 << 4) != 0) && (move[nr][nc][keys] > steps + 1)) {
						move[nr][nc][keys] = steps + 1;
						queue.add(new int[] { nr, nc, steps + 1, keys });
					}
					if (cur.equals("F") && ((keys & 1 << 5) != 0) && (move[nr][nc][keys] > steps + 1)) {
						move[nr][nc][keys] = steps + 1;
						queue.add(new int[] { nr, nc, steps + 1, keys });
					}

				}
			}
		}

		return -1;
	}
}
