import java.io.*;
import java.util.*;

public class Main {

    static String[][] map;
    static boolean[][] visit;
    static int N;

    // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new String[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }

        int normal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visit[i][j]) {
                    normal++;
                    visit[i][j] = true;
                    DFS(j, i, map[i][j]);
                }
            }
        }

        int weakness = 0;
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visit[i][j]) {
                    weakness++;
                    visit[i][j] = true;
                    DFS2(j, i, map[i][j]);
                }
            }
        }

        System.out.println(normal + " " + weakness);
    }

    static void DFS(int x, int y, String color) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                continue;

            if (!visit[nextY][nextX] && map[nextY][nextX].equals(color)) {
                visit[nextY][nextX] = true;
                DFS(nextX, nextY, color);
            }
        }
    }

    static void DFS2(int x, int y, String color) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                continue;

            if (!visit[nextY][nextX]) {

                if (map[nextY][nextX].equals(color)) {
                    visit[nextY][nextX] = true;
                    DFS2(nextX, nextY, color);
                } else {
                    if (map[nextY][nextX].equals("R") || map[nextY][nextX].equals("G")) {

                        if (color.equals("R") || color.equals("G")) {
                            visit[nextY][nextX] = true;
                            DFS2(nextX, nextY, color);
                        }
                    }
                }

            }
        }
    }
}
