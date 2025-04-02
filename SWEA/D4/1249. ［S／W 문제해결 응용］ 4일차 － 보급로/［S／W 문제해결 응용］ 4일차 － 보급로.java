import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[][] map;
	static int[][] minDist;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static final int INF = 100000;

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int weight;

		public Point(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			minDist = new int[N][N];
			for (int j = 0; j < N; j++) {
				String a = br.readLine();

				for (int k = 0; k < N; k++) {
					map[j][k] = a.charAt(k) - '0';
					minDist[j][k] = INF;
				}
			}

			bfs();
			sb.append("#").append(i + 1).append(" ").append(minDist[N - 1][N - 1]).append("\n");
		}

		System.out.print(sb);
	}

	private static void bfs() {

		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0, 0));
		minDist[0][0] = 0;

		while (!pq.isEmpty()) {
			Point poll = pq.poll();

			if (poll.r == N - 1 && poll.c == N - 1)
				return;

			if (minDist[poll.r][poll.c] < poll.weight)
				continue;

			for (int i = 0; i < 4; i++) {

				int nr = poll.r + dr[i];
				int nc = poll.c + dc[i];

				if (!check(nr, nc))
					continue;

				if (minDist[nr][nc] > poll.weight + map[nr][nc]) {
					minDist[nr][nc] = poll.weight + map[nr][nc];

					pq.add(new Point(nr, nc, minDist[nr][nc]));
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
