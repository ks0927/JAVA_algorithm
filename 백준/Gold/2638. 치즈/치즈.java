import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static boolean noMoreCheese;
    static int time = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        while (true) {
            visited = new boolean[N][M];
            noMoreCheese = true;
            fillAir(0, 0);

            if (noMoreCheese) break;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        checkMelt(i, j);
                    }
                }
            }
            time++;

        }

        System.out.println(time);

    }

    private static void checkMelt(int r, int c) {
        int check = 0;
        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

                if (map[nr][nc] == 2) {
                    check++;
                }

                if (check == 2) {
                    map[r][c] = 0;
                    break;
                }
            }
        }

    }

    private static void fillAir(int r, int c) {
        visited[r][c] = true;
        map[r][c] = 2;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int[] poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nr = dr[j] + poll[0];
                    int nc = dc[j] + poll[1];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                        if (map[nr][nc] != 1) {
                            visited[nr][nc] = true;
                            queue.add(new int[]{nr, nc});
                            map[nr][nc] = 2;
                        } else {
                            noMoreCheese = false;
                        }

                    }
                }
            }
        }
    }


}
