import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] check;
    static int[][] temp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int result;
    static int flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char v = str.charAt(j);

                if (v == 'U') {
                    map[i][j] = 1;
                }
                if (v == 'D') {
                    map[i][j] = 2;
                }
                if (v == 'L') {
                    map[i][j] = 3;
                }
                if (v == 'R') {
                    map[i][j] = 4;
                }

            }
        }
        result = 0;
        flag = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check[i][j] == 0) {
                    moving(i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static void moving(int r, int c) {
        int nr = r;
        int nc = c;

        List<int[]> path = new ArrayList<>();

        while (true) {
            path.add(new int[] {nr,nc});
            check[nr][nc] = flag;
            int direct = map[nr][nc] - 1;

            nr = nr + dr[direct];
            nc = nc + dc[direct];

            if (check[nr][nc] == flag) {
                result++;
                flag++;
                break;
            }

            if (check[nr][nc] != flag && check[nr][nc] != 0) {

                for (int[] ints : path) {
                    check[ints[0]][ints[1]] = Math.min(flag, check[nr][nc]);
                }
                break;
            }
        }

    }

}
