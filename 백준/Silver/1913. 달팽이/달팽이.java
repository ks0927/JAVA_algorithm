import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int N;
    static int M;
    static int R;
    static int C;

    // 하 우 상 좌
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        arr[0][0] = N * N;
        fill();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        System.out.print(R + " " + C);
    }

    public static void fill() {
        int r = 0;
        int c = 0;
        int num = N * N;
        int turn = 0;

        while (num > 1) {

            if (num == M) {
                R = r + 1;
                C = c + 1;
            }

            if (!(r + dr[turn] >= 0 && r + dr[turn] < N && c + dc[turn] >= 0 && c + dc[turn] < N && arr[r + dr[turn]][c + dc[turn]] == 0)) {
                turn++;
                turn %= 4;
            }

            r += dr[turn];
            c += dc[turn];
            num--;
            arr[r][c] = num;

        }
        if(num == 1 && M == 1) {
            R = r + 1;
            C = c + 1;
        }
    }

}
