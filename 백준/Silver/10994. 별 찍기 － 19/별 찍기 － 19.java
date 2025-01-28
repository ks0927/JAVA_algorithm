import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        arr = new int[4 * (N - 1) + 1][4 * (N - 1) + 1];

        fill(0, 0, N);

        for (int i = 0; i < 4 * (N - 1) + 1; i++) {
            for (int j = 0; j < 4 * (N - 1) + 1; j++) {
                if (arr[i][j] == 0)
                    sb.append(" ");
                if (arr[i][j] == 1)
                    sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void fill(int r, int c, int N) {

        if (N == 0) {
            return;
        }

        for (int i = r; i < r + 4 * (N - 1) + 1; i++) {
            for (int j = c; j < c + 4 * (N - 1) + 1; j++) {
                if (i == r || i == r + 4 * (N - 1)) {  //사각형의 윗변 아랫변
                    arr[i][j] = 1;
                } else {
                    arr[i][c] = 1;                      //사각형의 왼변
                    arr[i][c + 4 * (N - 1)] = 1;        //사각형의 오른변
                }

            }
        }

        fill(r + 2, c + 2, N - 1);
    }

}
