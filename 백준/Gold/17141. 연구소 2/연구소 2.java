import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static final int MAX =100000;
    static int min;
    static int blanks;
    static int[][] map;
    static ArrayList<int[]> vi;
    static ArrayList<int[]> blocks;
    static int[] idx;
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, 1, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vi = new ArrayList<>();
        blocks = new ArrayList<>();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                if (value == 2) {
                    vi.add(new int[]{i, j});
                }
                if (value == 1) {
                    blocks.add(new int[]{i, j});
                }
            }
        }
        min = MAX;
        blanks = N * N - M - blocks.size();
        idx = new int[M];
        combi(0, 0);

        System.out.println(min == MAX ? -1 : min);
    }

    private static void combi(int depth, int start) {

        if (depth == M) {
            bfs();
            return;
        }

        for (int i = start; i < vi.size(); i++) {
            idx[depth] = i;
            combi(depth + 1, i+1);
        }
    }

    private static void bfs() {
        int[][] move = new int[N][N];

        Queue<int[]> virus = new ArrayDeque<>();

        for (int[] i1 : blocks) {
            move[i1[0]][i1[1]] = -1;
        }

        for (int index : idx) {
            int[] is = vi.get(index);
            virus.add(is);
            move[is[0]][is[1]] = -2;
        }
        int level = 0;
        int sum = 0;
        while (!virus.isEmpty()) {
            if (blanks - sum == 0) {
                min = Math.min(min, level);
                return;
            }

            if(level >= min){
                return;
            }

            int size = virus.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] poll = virus.poll();
                int r = poll[0];
                int c = poll[1];

                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if (!check(nr, nc))
                        continue;

                    if (move[nr][nc] == 0) {
                        move[nr][nc] = level;
                        sum++;
                        virus.add(new int[]{nr, nc});
                    }
                }
            }
        }

    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
