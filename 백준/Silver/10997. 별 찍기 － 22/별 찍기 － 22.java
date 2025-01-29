import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int N;
    static int R;
    static int C;

    // 좌 하 우 상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println("*");
            return;
        }

        StringBuilder sb = new StringBuilder();

        arr = new int[4 * (N - 1) + 3][4 * (N - 1) + 1];
        int r = 0;
        int c = 4 * (N - 1);
        int tryC = 4 * (N - 1);
        int tryR = 4 * (N - 1) + 2;
        int flag = 0;
        boolean first = true;
        while (tryC != 0 && tryR != 0) {

            for (int i = 0; i < tryC; i++) {
                arr[r][c] = 1;
                r += dr[flag];
                c += dc[flag];
            }
            arr[r][c] = 1;

            flag = (flag + 1) % 4;
            if (first) {
                first = false;
            } else {
                tryC -= 2;
            }

            for (int i = 0; i < tryR; i++) {
                r += dr[flag];
                c += dc[flag];
                arr[r][c] = 1;
            }
            flag = (flag + 1) % 4;
            tryR -= 2;
        }

        for (int i = 0; i < 4 * (N - 1) + 3; i++) {
            for (int j = 0; j < 4 * (N - 1) + 1; j++) {
                sb.append(arr[i][j] == 1 ? "*" : " ");
            }
            if (i == 1) {
                for (int j = 0; j < 4 * (N - 1); j++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }


}
