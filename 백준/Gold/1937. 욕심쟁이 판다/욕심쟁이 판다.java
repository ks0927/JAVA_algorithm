import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int max;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (dp[i][j] == 0) {
                    max = Math.max(max, dfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    private static int dfs(int r, int c) {

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int value = 1;

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!check(nr, nc)) continue;

            if (map[nr][nc] > map[r][c]) {
                value = Math.max(value, dfs(nr, nc) + 1);
            }
        }

        dp[r][c] = value;
        return value;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
