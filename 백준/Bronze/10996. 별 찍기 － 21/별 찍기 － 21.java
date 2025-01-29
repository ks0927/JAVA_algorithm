import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int N;
    static int R;
    static int C;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        arr = new int[N * 2][N];

        for (int i = 0; i < N * 2; i++) {
            for (int j = 0; j < N; j++) {

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                } else {
                    if (j % 2 == 0) {
                        sb.append(" ");
                    } else {
                        sb.append("*");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }


}
