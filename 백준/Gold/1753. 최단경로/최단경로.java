import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static ArrayList<Point>[] map;
    static int[] distance;
    static final int INF = 100000000;

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        map = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[s].add(new Point(e, w));
        }
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        }
        
        System.out.print(sb);
    }

    private static void dijkstra(int start) {

        distance = new int[V + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point poll = pq.poll();
            int cur = poll.v;
            int w = poll.w;

            // 우선순위 큐에서 꺼낸 노드가 이미 더 짧은 경로로 처리되었다면 스킵
            if(distance[cur] < w) continue;

            for (int i = 0; i < map[cur].size(); i++) {
                Point next = map[cur].get(i);

                if(distance[next.v] > distance[cur] + next.w) {
                    distance[next.v] = distance[cur] + next.w;
                    pq.add(new Point(next.v,distance[next.v]));
                }

            }
        }

    }


}