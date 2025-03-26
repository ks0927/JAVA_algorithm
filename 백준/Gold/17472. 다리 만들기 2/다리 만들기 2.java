import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] island;
    static boolean[][] visited;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int islandCount;
    static int[] p;
    static int[] r;
    static class Point implements Comparable<Point> {
        int s;
        int e;
        int w;

        public Point(int s, int e, int w) {
            this.s = s;
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        island = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        islandCount = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, islandCount);
                    islandCount++;
                }
            }
        }
        islandCount--;

        Queue<int[]> outside = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (island[i][j] != 0) {

                    for (int j2 = 0; j2 < 4; j2++) {
                        int r = i + dr[j2];
                        int c = j + dc[j2];

                        if (!check(r, c))
                            continue;

                        if (island[r][c] == 0) {
//                            island[i][j] *= -1;
                            outside.add(new int[]{i, j});
                            break;
                        }
                    }

                }
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();

        while (!outside.isEmpty()) {
            int[] poll = outside.poll();

            for (int i = 0; i < 4; i++) {
                int tr = poll[0];
                int tc = poll[1];
                int value = island[tr][tc];
                int count = -1;
                while (true) {
                    tr = tr + dr[i];
                    tc = tc + dc[i];
                    count++;
                    if (!check(tr, tc)) break;

                    if (island[tr][tc] == value) break;

                    if (island[tr][tc] != value && island[tr][tc] != 0) {
                        if(count > 1){
                            pq.add(new Point(value,island[tr][tc],count));
                        }
                        break;
                    }
                }
            }
        }

        init();

        int result = 0;
        int bridge = 0;
        while (!pq.isEmpty()){
            Point poll = pq.poll();

            int s = poll.s;
            int e = poll.e;

            if(union(s,e)) {
                bridge++;
                result+= poll.w;

                if(bridge == (islandCount-1)) {
                    break;
                }
            }
        }

        System.out.println((bridge == islandCount -1) ? result : -1);
    }

    public static void init() {
        p = new int[islandCount+1];
        r = new int[islandCount+1];

        for (int i = 0; i <= islandCount; i++) {
            p[i] = i;
            r[i] = 1;
        }
    }

    public static int find(int a) {
        if(p[a] == a) return p[a];
        return p[a] = find(p[a]);
    }

    public static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x == y) return false;

        if(r[x] > r[y]) {
            p[y] = x;
            r[x] += r[y];
        }else {
            p[x] = y;
            r[y] += r[x];
        }
        return true;
    }
    public static void bfs(int r, int c, int cnt) {
        visited[r][c] = true;
        island[r][c] = cnt;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{r, c});

        while (!que.isEmpty()) {

            int[] poll = que.poll();
            int tr = poll[0];
            int tc = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = tr + dr[i];
                int nc = tc + dc[i];

                if (!check(nr, nc))
                    continue;

                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    island[nr][nc] = cnt;
                    visited[nr][nc] = true;
                    que.add(new int[]{nr, nc});
                }
            }
        }

    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
