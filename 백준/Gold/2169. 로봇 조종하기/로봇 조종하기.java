import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];

        dp[0][0] = map[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        for (int i = 1; i < N; i++) {

            // 왼쪽 오른쪽 기록용 임시 리스트
            int[][] temp = new int[M][2];
            // 오른쪽 이동
            temp[0][0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                temp[j][0] = Math.max(temp[j - 1][0], dp[i - 1][j]) + map[i][j];
            }

            // 왼쪽 이동
            temp[M - 1][1] = dp[i - 1][M - 1] + map[i][M - 1];
            for (int j = M -2; j >= 0; j--) {
                temp[j][1] = Math.max(temp[j + 1][1], dp[i - 1][j]) + map[i][j];
            }

            // 왼쪽과 오른쪽을 비교해서 큰값을 dp에 기록한다.
            for (int j = 0; j < M; j++) {
                if (temp[j][0] > temp[j][1]) {
                    dp[i][j] = temp[j][0];
                } else {
                    dp[i][j] = temp[j][1];
                }
            }

        }

        System.out.println(dp[N - 1][M - 1]);
    }

}
