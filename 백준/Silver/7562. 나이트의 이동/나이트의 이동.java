import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dc = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            L = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int gr = Integer.parseInt(st.nextToken());
            int gc = Integer.parseInt(st.nextToken());

            if (r == gr && c == gc) {
                sb.append(0).append("\n");
                continue;
            }

            map = new int[L][L];
            visited = new boolean[L][L];
            map[r][c] = 1;
            map[gr][gc] = -1;

            int bfs = bfs(r, c);
            sb.append(bfs).append("\n");
        }

        System.out.print(sb);
    }

    private static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();

                for (int j = 0; j < 8; j++) {
                    int nr = poll[0] + dr[j];
                    int nc = poll[1] + dc[j];

                    if (!(nr >= 0 && nr < L && nc >= 0 && nc < L)) continue;

                    if (!visited[nr][nc]) {
                        if (map[nr][nc] == -1) return level;

                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        map[nr][nc] = level;
                    }

                }
            }
        }

        return -1;
    }


}
