import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        dp = new int[N][N]; // 세로 즉 열의 합을 담고있다.

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        // dp배열 초기화
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += map[j][i];
                dp[j][i] = sum;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = calculate(x1 - 1, y1 - 1, x2 - 1, y2 - 1);
            sb.append(result).append("\n");
        }

        System.out.print(sb);

    }

    // 세로의 합인 dp를 순회한다.
    // 단 행이 x2일때 y1열부터 y2열까지 더한뒤
    // x1행이 0이 아니면 x1 - 1 행의 y1열 부터 y2열 까지 빼준다.
    //    예를 들자면 다음과 같은 표가 있다면
    //            1 2 3 4
    //            2 3 4 5
    //            3 4 5 6
    //            4 5 6 7
    //    dp는 다음과 같이 구성된다.
    //        1 2 3 4
    //        3 5 7 9
    //        6 9 12 15
    //        10 14 18 22
    //    이때 (2,2) 부터 (4,4) 까지 구한다고 생각하면
    //            1  2 3  4
    //            2 |3 4| 5
    //            3 |4 5| 6
    //            4 |5 6| 7
    //    표에서 해당 값을 구해야한다. 따라서 dp에서는
    //    14 와 18을 더한뒤 2와 3을 빼면 된다.
    static int calculate(int x1, int y1, int x2, int y2) {
        int result = 0;

        for (int i = y1; i <= y2; i++) {
            result += dp[x2][i];
        }

        if (x1 != 0) {
            for (int i = y1; i <= y2; i++) {
                result -= dp[x1 - 1][i];
            }
        }
        return result;

    }

}
