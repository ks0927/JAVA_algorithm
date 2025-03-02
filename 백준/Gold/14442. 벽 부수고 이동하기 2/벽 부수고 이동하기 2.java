import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int N;
    static int M;
    static int K;
    static int[][][] move;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        move = new int[K+1][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int value = str.charAt(j) - '0';
                map[i][j] = value;
            }
        }

        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    move[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int r, int c) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 1, K});
        move[K][r][c] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int tr = poll[0];
                int tc = poll[1];
                int moving = poll[2];
                int breakChance = poll[3];

                if (tr == N - 1 && tc == M - 1) {
                    return moving;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = tr + dr[j];
                    int nc = tc + dc[j];

                    if (!check(nr, nc)) continue;

                    if (map[nr][nc] == 1 && breakChance > 0) {
                        if (move[breakChance - 1][nr][nc] > moving + 1) {
                            move[breakChance - 1][nr][nc] = moving + 1;
                            queue.add(new int[]{nr, nc, moving + 1, breakChance - 1});
                        }
                    }

                    if (map[nr][nc] == 0) {
                        if (move[breakChance][nr][nc] > moving + 1) {
                            move[breakChance][nr][nc] = moving + 1;
                            queue.add(new int[]{nr, nc, moving + 1, breakChance});
                        }
                    }

                }
            }

        }

        return -1;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }


}