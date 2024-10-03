import java.io.*;
import java.util.*;

public class Main {
    static int ans = 1;
    static boolean[] visited = new boolean[26];
    static char[][] map;
    static int[] directionR = {-1, 1, 0, 0};
    static int[] directionC = {0, 0, -1, 1};
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
            }
        }

        visited[map[0][0] - 'A'] = true;
        DFS(0, 0, 1);

        System.out.println(ans);
    }


    static void DFS(int r, int c, int len) {
        if (len > ans)
            ans = len;

        for (int i = 0; i < 4; i++) {
            int nextR = r + directionR[i];
            int nextC = c + directionC[i];

            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C)
                continue;

            char nextValue = map[nextR][nextC];
            if (!visited[nextValue - 'A']) {
                visited[nextValue - 'A'] = true;
                DFS(nextR, nextC, len + 1);
                visited[nextValue - 'A'] = false;
            }
        }

    }


}
