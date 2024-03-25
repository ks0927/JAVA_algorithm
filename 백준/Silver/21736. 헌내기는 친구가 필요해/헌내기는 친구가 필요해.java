import java.io.*;
import java.util.*;

public class Main {
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    static boolean[][] visited;
    static String[][] campus;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        campus = new String[N][M];
        visited = new boolean[N][M];

        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            String strs = br.readLine();
            for (int j = 0; j < M; j++) {
                String str = String.valueOf(strs.charAt(j));

                campus[i][j] = str;
                if (str.equals("I")) {
                    x = j;
                    y = i;
                }
            }
        }

        visited[y][x] = true;

        DFS(x, y, M, N);

        if(count == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(count);
    }

    static void DFS(int x, int y, int M, int N) {

        for (int i = 0; i < 4; i++) {
            int nextX = x + directionX[i];
            int nextY = y + directionY[i];
            if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && !visited[nextY][nextX] && !campus[nextY][nextX].equals("X")) {

                visited[nextY][nextX] = true;
                if (campus[nextY][nextX].equals("P")) {
                    count++;
                }
                DFS(nextX, nextY, M, N);
            }
        }
    }


}
