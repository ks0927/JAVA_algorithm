import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[N + 1];
        Long[] dp = new Long[N + 1];

        st = new StringTokenizer(br.readLine());

        Long dpValue = 0L;
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            map[i] = value;
            dpValue += value;
            dp[i] = dpValue;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 1) {
                sb.append(dp[end]).append("\n");
            } else {
                Long result = dp[end] - dp[start - 1];
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }


}

