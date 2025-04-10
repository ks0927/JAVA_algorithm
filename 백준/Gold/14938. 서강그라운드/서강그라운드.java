import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point> {
        int e;
        int w;

        public Point(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return (Integer.compare(this.w, o.w));
        }
    }

    static int N, M, R;
    static List<Point>[] map;
    static int[] items;
    static final int INF = 10000;
    static int[][] fw;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        items = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[s].add(new Point(e, w));
            map[e].add(new Point(s, w));
        }

        fw = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                fw[i][j] = INF;
            }
        }

        for (int i = 1; i <= N; i++) {
            dijk(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (fw[i][j] == INF)
                    continue;

                if (i == j) {
                    sum += items[j];
                    continue;
                }

                if (fw[i][j] <= M) {
                    sum += items[j];
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    private static void dijk(int start) {

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(start, 0));
        fw[start][start] = 0;

        while (!pq.isEmpty()) {
            Point poll = pq.poll();

            if (poll.w > fw[start][poll.e])
                continue;

            for (int i = 0; i < map[poll.e].size(); i++) {
                Point next = map[poll.e].get(i);

                if (fw[start][next.e] > fw[start][poll.e] + next.w) {
                    fw[start][next.e] = fw[start][poll.e] + next.w;
                    pq.add(new Point(next.e, fw[start][next.e]));
                }
            }
        }

    }

}
