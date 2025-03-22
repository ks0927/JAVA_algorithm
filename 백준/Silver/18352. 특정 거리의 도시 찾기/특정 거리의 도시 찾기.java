import java.util.*;
import java.io.*;

public class Main {

    static final int MAX = 1000000000;

    static class Point implements Comparable<Point> {
        int e;
        int w;

        public Point(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Point>[] map = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s].add(new Point(e, 1));
        }
        int[] dis = new int[N + 1];

        Arrays.fill(dis, MAX);
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(X, 0));
        dis[X] = 0;

        while (!pq.isEmpty()) {
            Point poll = pq.poll();
            int cur = poll.e;
            int cw = poll.w;

            //이미 현재가 작은값으로 초기화 되었다면 스킵
            if (dis[cur] < cw) continue;

            for (int i = 0; i < map[cur].size(); i++) {
                Point next = map[cur].get(i);
                int nw = next.w;

                if (dis[next.e] > dis[cur] + nw) {
                    dis[next.e] = dis[cur] + nw;
                    pq.add(new Point(next.e, dis[next.e]));
                }
            }
        }

        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(dis[i] == K) {
                sol.add(i);
            }
        }

        if(sol.size() == 0){
            System.out.println(-1);
        }else {
            StringBuilder sb = new StringBuilder();

            Collections.sort(sol);
            for (Integer i : sol) {
                sb.append(i).append("\n");
            }
            System.out.print(sb);
        }
    }


}
