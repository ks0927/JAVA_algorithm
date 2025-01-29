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

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2 * N - 1; i++) {

            //빈칸
            for (int j = 0; j < -Math.abs(i - (N - 1)) + N - 1; j++) {
                sb.append(" ");
            }

            //별찍기
            if (i == 0 || i == 2 * N - 2) {            //맨위 맨아래 별
                for (int j = 0; j < N; j++) {
                    sb.append("*");
                }
            } else if (i == N - 1) {            //중간 별
                sb.append("*");
                for (int j = 0; j < N - 2; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            } else {                        //기본 별
                sb.append("*");
                for (int j = 0; j < N - 2; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            }

            // 중간 빈칸
            for (int j = 0; j < 2 * Math.abs(i - (N - 1)) - 1; j++) {
                sb.append(" ");
            }

            //별찍기
            if (i == 0 || i == 2 * N - 2) {            //맨위 맨아래 별
                for (int j = 0; j < N; j++) {
                    sb.append("*");
                }
            } else if (i == N - 1) {            //중간 별
                for (int j = 0; j < N - 2; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            } else {                        //기본 별
                sb.append("*");
                for (int j = 0; j < N - 2; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }

}
