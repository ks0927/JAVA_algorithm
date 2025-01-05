import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[] Aj = new int[N];
            int[] Bj = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                Aj[j] = value;
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                Bj[j] = value;
            }

            int result = calculate(Aj, Bj);
            sb.append("#").append(i+1).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int calculate(int[] aj, int[] bj) {

        int max = 0;
        int weight = 0;
        if (N > M) {

            while (true) {
                int sum = 0;

                if (weight + M > N) {
                    break;
                }

                for (int i = 0; i < M; i++) {
                    sum += bj[i] * aj[i+weight];
                }

                max = Integer.max(max, sum);
                weight++;
            }
        }else {

            while (true) {
                int sum = 0;

                if (weight + N > M) {
                    break;
                }

                for (int i = 0; i < N; i++) {
                    sum += aj[i] * bj[i+weight];
                }
                max = Integer.max(max, sum);
                weight++;
            }
        }

        return max;
    }


}
