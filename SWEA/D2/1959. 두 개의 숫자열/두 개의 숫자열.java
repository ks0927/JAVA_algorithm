import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arrayN = new int[N];
            int[] arrayM = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                arrayN[j] = parseInt;
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                arrayM[j] = parseInt;
            }

            int max = 0;
            if (N > M) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int k = 0; k < M; k++) {
                        sum += arrayN[k + j] * arrayM[k];
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            } else {
                for (int j = 0; j <= M - N; j++) {
                    int sum = 0;
                    for (int k = 0; k < N; k++) {
                        sum += arrayM[k + j] * arrayN[k];
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            sb.append("#").append(i + 1).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }


}
