import java.io.*;
import java.util.*;

public class Main {

    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] color = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];

        dp[0][RED] = color[0][RED];
        dp[0][GREEN] = color[0][GREEN];
        dp[0][BLUE] = color[0][BLUE];

        for (int i = 1; i < N; i++) {
            dp[i][RED] = Math.min(dp[i - 1][BLUE], dp[i - 1][GREEN]) + color[i][RED];
            dp[i][GREEN] = Math.min(dp[i - 1][BLUE], dp[i - 1][RED]) + color[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + color[i][BLUE];
        }

        int result = Integer.MAX_VALUE;
        if(result > dp[N - 1][RED])
            result = dp[N - 1][RED];

        if(result > dp[N - 1][GREEN])
            result = dp[N - 1][GREEN];

        if(result > dp[N - 1][BLUE])
            result = dp[N - 1][BLUE];

        System.out.println(result);
    }
}
