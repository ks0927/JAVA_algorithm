import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] copyMap;
    static int[] nums;
    static int N;
    static int M;
    static int max;
    static int safe;
    static ArrayList<int[]> virus;
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        safe = 0;
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                if (value == 2) {
                    virus.add(new int[]{i, j});
                }

                if (value == 0) {
                    safe++;
                }
            }
        }
        safe -= 3;
        max = 0;
        nums = new int[3];
        combi(0, 0);

        System.out.println(max);
    }

    private static void combi(int depth, int start) {
        if (depth == 3) {
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                copyMap[i] = map[i].clone();
            }

            for (int i = 0; i < 3; i++) {
                int r = nums[i] / M;
                int c = nums[i] % M;
                copyMap[r][c] = 1;
            }
            bfs();

            return;
        }

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;

            if (map[r][c] == 0) {
                nums[depth] = i;
                combi(depth + 1, i + 1);
                nums[depth] = 0;
            }
        }

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] ints : virus) {
            int r = ints[0];
            int c = ints[1];
            queue.add(new int[]{r, c});
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int tr = poll[0];
                int tc = poll[1];

                for (int j = 0; j < 4; j++) {
                    int nr = tr + dr[j];
                    int nc = tc + dc[j];

                    if (!check(nr, nc)) continue;

                    if (copyMap[nr][nc] == 0) {
                        copyMap[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                        sum++;
                    }
                }
            }
        }
        max = Math.max(max, safe - sum);
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}