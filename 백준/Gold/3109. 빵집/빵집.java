import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    // 우상 우 우하 3방탐색
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    // . 을 0으로
    // x 를 1으로
    static int[][] map;
    static int pipe;
    static boolean reach;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) == 'x' ? 1 : 0;
            }
        }

        pipe = 0;
        for (int i = 0; i < R; i++) {
            reach = false;
            map[i][0] = 1;
            dfs(i, 0);
        }

        System.out.println(pipe);
    }

    public static void dfs(int r, int c) {
        if (c == C - 1) {
            reach = true;
            pipe++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < R & nc >= 0 && nc < C) {
                if (!reach && map[nr][nc] == 0) {
                    map[nr][nc] = 1;
                    dfs(nr, nc);

                    if(reach) return;

//                    map[nr][nc] = 0;
                }
            }
        }

    }
}
