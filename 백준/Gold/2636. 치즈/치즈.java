import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] melt;
    static boolean[][] visited;
    static int meltCount;
    static int time = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        melt = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        while (true) {
            visited = new boolean[N][M];
            melt = new boolean[N][M];
            meltingPointCheck(0, 0);
            time++;

            if (melting()) {
                break;
            }
        }

        System.out.println(time);
        System.out.println(meltCount);

    }

    private static boolean melting() {
        meltCount = 0;
        boolean canLast = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (melt[i][j] && map[i][j] == 1) {
                    map[i][j] = 0;
                    meltCount++;
                }

                if (map[i][j] == 1) {
                    canLast = false;
                }
            }
        }
        return canLast;
    }

    private static void meltingPointCheck(int r, int c) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();

                int tr = poll[0];
                int tc = poll[1];

                for (int j = 0; j < 4; j++) {
                    int nr = tr + dr[j];
                    int nc = tc + dc[j];

                    if (nr >= 0 && nr < N & nc >= 0 && nc < M) {

                        if (!visited[nr][nc] && map[nr][nc] == 0) {
                            visited[nr][nc] = true;
                            queue.add(new int[]{nr, nc});
                        }

                        if (map[nr][nc] == 1) {
                            melt[nr][nc] = true;
                        }
                    }
                }

            }
        }


    }


}
