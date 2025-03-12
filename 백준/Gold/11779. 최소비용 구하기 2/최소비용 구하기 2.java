import java.io.*;
import java.util.*;

public class Main {

	static class Point implements Comparable<Point> {
		int v;
		int w;
		ArrayList<Integer> route;

		Point(int v, int w) {
			this.v = v;
			this.w = w;
			route = new ArrayList<>();
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static ArrayList<Point>[] adj;
	static int N;
	static int M;
	static int min;
	static int[] distance;
	static ArrayList<Integer> minRoute;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[v].add(new Point(e, w));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		distance = new int[N + 1];
		min = Integer.MAX_VALUE;
		dijkstra(start, end);

		StringBuilder sb = new StringBuilder();
		sb.append(distance[end]).append("\n");
		sb.append(minRoute.size()).append("\n");
		for (int no : minRoute) {
			sb.append(no).append(" ");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start, int end) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		PriorityQueue<Point> pq = new PriorityQueue();
		
		Point startNode = new Point(start, 0);
		startNode.route.add(start);
		pq.add(startNode);

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (distance[cur.v] < cur.w)
				continue;

			for (int i = 0; i < adj[cur.v].size(); i++) {
				Point next = adj[cur.v].get(i);

				if (distance[next.v] > distance[cur.v] + next.w) {
					distance[next.v] = distance[cur.v] + next.w;
					Point nextNode = new Point(next.v, distance[next.v]);
					nextNode.route.addAll(cur.route);
					nextNode.route.add(next.v);
					
					if(next.v == end) {
						minRoute = nextNode.route;
					}
					pq.add(nextNode);
				}
			}
		}

	}

}
