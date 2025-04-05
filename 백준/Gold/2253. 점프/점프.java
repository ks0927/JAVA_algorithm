import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] dp;
    static HashMap<Integer, Integer> checkRemove;
    static final int INF = 1000001;
    static final int MAXSPEED = 142;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][MAXSPEED];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < MAXSPEED; j++) {
                dp[i][j] = INF;
            }
        }
        checkRemove = new HashMap<>();
        for (int i = 0; i < M; i++) {
            checkRemove.put(Integer.parseInt(br.readLine()), 1);
        }

        dp[1][0] = 0;

        for (int i = 1; i <= N; i++) {
            if (checkRemove.containsKey(i)) {
                continue;
            }

            for (int j = 0; j < MAXSPEED; j++) {
                if (dp[i][j] != INF) {

                    int jumps = dp[i][j]; // j만큼의 속력으로 i에 도달하는데 사용한 점프 횟수
                    jumping(j, i, jumps, 1);
                    jumping(j, i, jumps, 0);
                    jumping(j, i, jumps, -1);
                }
            }

        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < MAXSPEED; i++) {
            result = Math.min(result, dp[N][i]);
        }

        System.out.println(result == INF ? -1 : result);

    }

    private static void jumping(int speed, int i, int jumpCount, int weight) {
        int acc = speed + weight;

        if (acc >= 1) {

            int nextStone = i + acc;
            if (checkRemove.containsKey(i)) return;

            if (!(nextStone >= 0 && nextStone <= N)) return;

            if (dp[nextStone][acc] > jumpCount + 1) {
                dp[nextStone][acc] = jumpCount + 1;
            }
        }

    }

}
