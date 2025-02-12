import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] move;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        move = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                move[i][j] = value;
            }
        }
        //R번 회전 모듈러 연산
//        R %= (2 * (N + M) - 4);

        for (int i = 0; i < R; i++) {
            rotate(0, 0);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(move[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 1 4 
    // 2 3
    private static void rotate(int r, int c) {
        int r1 = r;
        int c1 = c;

        int r2 = N - 1;
        int c2 = 0;

        int r3 = N - 1;
        int c3 = M - 1;

        int r4 = 0;
        int c4 = M - 1;

        int inner = Math.min(N, M) / 2;

        while (inner > 0) {

            // 아래쪽 이동
            for (int i = r1; i < r2; i++) {
                move[i + 1][c1] = map[i][c1];
            }

            //오른쪽 이동
            for (int i = c2; i < c3; i++) {
                move[r2][i + 1] = map[r2][i];
            }

            // 위쪽 이동
            for (int i = r3; i > r4; i--) {
                move[i - 1][c3] = map[i][c3];
            }

            // 왼쪽 이동
            for (int i = c4; i > c1; i--) {
                move[r4][i - 1] = map[r4][i];
            }

            r1 += 1;
            c1 += 1;
            r2 -= 1;
            c2 += 1;
            r3 -= 1;
            c3 -= 1;
            r4 += 1;
            c4 -= 1;

            inner--;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = move[i][j];
            }
        }
    }


}
