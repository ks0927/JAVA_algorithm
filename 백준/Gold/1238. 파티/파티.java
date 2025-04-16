import java.io.*;
import java.util.*;

public class Main {

	static class Point implements Comparable<Point> {
		int v;
		int w;

		public Point(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static ArrayList<Point>[] map;

	static int N, M, X;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[s].add(new Point(e, w));
		}

		max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, di(i, X) + di(X, i));
		}

		System.out.println(max);
	}

	private static int di(int start, int end) {

		int[] dist = new int[N + 1];

		Arrays.fill(dist, 1_000_000_000);
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Point poll = pq.poll();

			if (poll.v == end) {
				return dist[end];
			}

			if (dist[poll.v] < poll.w)
				continue;

			for (int i = 0; i < map[poll.v].size(); i++) {
				Point p = map[poll.v].get(i);

				if (dist[p.v] > dist[poll.v] + p.w) {
					dist[p.v] = dist[poll.v] + p.w;
					pq.add(new Point(p.v, dist[p.v]));
				}
			}
		}

		return -1;
	}
}
