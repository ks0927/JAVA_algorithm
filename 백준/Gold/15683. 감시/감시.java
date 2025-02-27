import java.io.*;
import java.util.*;

public class Main {

    static class cctv {
        int r;
        int c;
        int type;

        public cctv(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    static int[][] map;
    static int N;
    static int M;
    static ArrayList<cctv> cctvs;
    static int R;
    static int min;

    // 상하좌우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cctvs = new ArrayList<>();
        int blind = N * M;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                if (value != 0)
                    blind--;

                if (value != 0 && value != 6) {
                    cctvs.add(new cctv(i, j, value));
                }
            }
        }

        min = Integer.MAX_VALUE;
        R = cctvs.size();
        dfs(0, blind);

        System.out.println(min);
    }

    private static void dfs(int depth, int blind) {

        if (depth == R) {
            min = Math.min(blind, min);
            return;
        }

        cctv cctv = cctvs.get(depth);

        if (cctv.type == 1) {
            for (int j = 0; j < 4; j++) {
                ArrayList<int[]> canWatch = watch(cctv.r, cctv.c, cctv.type, new int[] { j });
                fill(canWatch, -1);
                dfs(depth + 1, blind - canWatch.size());

                fill(canWatch, 0);
            }
        }

        if (cctv.type == 2) {
            for (int j = 0; j < 4; j += 2) {
                ArrayList<int[]> canWatch = watch(cctv.r, cctv.c, cctv.type, new int[] { j });
                fill(canWatch, -1);
                dfs(depth + 1, blind - canWatch.size());

                fill(canWatch, 0);
            }
        }

        if (cctv.type == 3) {
            ArrayList<int[]> canWatch;
            canWatch = watch(cctv.r, cctv.c, cctv.type, new int[] { 0, 3 });
            fill(canWatch, -1);
            dfs(depth + 1, blind - canWatch.size());

            fill(canWatch, 0);

            canWatch = watch(cctv.r, cctv.c, cctv.type, new int[] { 0, 2 });
            fill(canWatch, -1);
            dfs(depth + 1, blind - canWatch.size());

            fill(canWatch, 0);

            canWatch = watch(cctv.r, cctv.c, cctv.type, new int[] { 1, 3 });
            fill(canWatch, -1);
            dfs(depth + 1, blind - canWatch.size());

            fill(canWatch, 0);

            canWatch = watch(cctv.r, cctv.c, cctv.type, new int[] { 1, 2 });
            fill(canWatch, -1);
            dfs(depth + 1, blind - canWatch.size());

            fill(canWatch, 0);
        }

        if (cctv.type == 4) {

            for (int j = 0; j < 4; j++) {
                ArrayList<int[]> canWatch = watch(cctv.r, cctv.c, cctv.type, new int[] { j });
                fill(canWatch, -1);
                dfs(depth + 1, blind - canWatch.size());

                fill(canWatch, 0);
            }
        }

        if (cctv.type == 5) {
            ArrayList<int[]> canWatch = watch(cctv.r, cctv.c, cctv.type, new int[] { 0 });
            fill(canWatch, -1);
            dfs(depth + 1, blind - canWatch.size());

            fill(canWatch, 0);
        }


    }

    private static void fill(ArrayList<int[]> canWatch, int type) {
        // #을 -1 로 표현
        if (type == -1) {
            for (int[] point : canWatch) {
                int r = point[0];
                int c = point[1];

                map[r][c] = -1;
            }
        }
        // 0으로 복원
        if (type == 0) {
            for (int[] point : canWatch) {
                int r = point[0];
                int c = point[1];

                map[r][c] = 0;
            }
        }
    }

    private static ArrayList<int[]> watch(int r, int c, int type, int[] rotate) {
        ArrayList<int[]> answer = new ArrayList<>();

        if (type == 1) {

            int tr = r;
            int tc = c;
            while (true) {
                tr = tr + dr[rotate[0]];
                tc = tc + dc[rotate[0]];

                if (!check(tr, tc))
                    break;

                if (map[tr][tc] == 6)
                    break;

                if (map[tr][tc] == 0) {
                    answer.add(new int[] { tr, tc });
                }
            }

        }
        if (type == 2) {

            int tr = r;
            int tc = c;
            while (true) {
                tr = tr + dr[rotate[0]];
                tc = tc + dc[rotate[0]];

                if (!check(tr, tc))
                    break;

                if (map[tr][tc] == 6)
                    break;

                if (map[tr][tc] == 0) {
                    answer.add(new int[] { tr, tc });
                }
            }

            tr = r;
            tc = c;
            while (true) {
                tr = tr + dr[rotate[0] + 1];
                tc = tc + dc[rotate[0] + 1];

                if (!check(tr, tc))
                    break;

                if (map[tr][tc] == 6)
                    break;

                if (map[tr][tc] == 0) {
                    answer.add(new int[] { tr, tc });
                }
            }

        }
        if (type == 3) {
            int tr = r;
            int tc = c;
            while (true) {
                tr = tr + dr[rotate[0]];
                tc = tc + dc[rotate[0]];

                if (!check(tr, tc))
                    break;

                if (map[tr][tc] == 6)
                    break;

                if (map[tr][tc] == 0) {
                    answer.add(new int[] { tr, tc });
                }
            }

            tr = r;
            tc = c;
            while (true) {
                tr = tr + dr[rotate[1]];
                tc = tc + dc[rotate[1]];

                if (!check(tr, tc))
                    break;

                if (map[tr][tc] == 6)
                    break;

                if (map[tr][tc] == 0) {
                    answer.add(new int[] { tr, tc });
                }
            }
        }
        if (type == 4) {
            for (int i = 0; i < 4; i++) {
                if (i == rotate[0])
                    continue;

                int tr = r;
                int tc = c;
                while (true) {
                    tr = tr + dr[i];
                    tc = tc + dc[i];

                    if (!check(tr, tc))
                        break;

                    if (map[tr][tc] == 6)
                        break;

                    if (map[tr][tc] == 0) {
                        answer.add(new int[] { tr, tc });
                    }
                }
            }
        }
        if (type == 5) {

            for (int i = 0; i < 4; i++) {
                int tr = r;
                int tc = c;
                while (true) {
                    tr = tr + dr[i];
                    tc = tc + dc[i];

                    if (!check(tr, tc))
                        break;

                    if (map[tr][tc] == 6)
                        break;

                    if (map[tr][tc] == 0) {
                        answer.add(new int[] { tr, tc });
                    }
                }
            }
        }
        return answer;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}