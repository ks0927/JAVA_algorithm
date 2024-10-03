import java.io.*;
import java.util.*;

public class Main {
    static int ans = 1;
    static ArrayList<Character> check = new ArrayList<>();
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

        check.add(map[0][0]);
        DFS(0, 0);

        System.out.println(ans);
    }


    static void DFS(int r, int c) {
        if (check.size() > ans)
            ans = check.size();

        for (int i = 0; i < 4; i++) {
            int nextR = r + directionR[i];
            int nextC = c + directionC[i];

            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C)
                continue;

            char nextValue = map[nextR][nextC];
            if (!check.contains(nextValue)) {
                check.add(nextValue);
                DFS(nextR, nextC);
                check.remove(check.size() - 1);
            }
        }

    }


}
