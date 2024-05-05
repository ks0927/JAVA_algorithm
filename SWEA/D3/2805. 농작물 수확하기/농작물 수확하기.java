import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            for (int j = 0; j < N; j++) {
                String readLine = br.readLine();
                for (int k = 0; k < N; k++) {
                    int parseInt = readLine.charAt(k) - '0';
                    map[j][k] = parseInt;
                }
            }

            int sum = 0;
            int point = (N / 2);
            for (int j = 0; j < N; j++) {

                // 중앙값
                sum += map[j][point];

                // 중앙기준 좌우 (중앙까지 상승)
                // 예시)
                //    *
                //   ***
                //  *****   <- 여기까지
                //   ***
                //    *
                if (j <= point) {
                    for (int k = 1; k <= j; k++) {
                        sum += map[j][point - k];
                        sum += map[j][point + k];
                    }
                } else {
                    // 중앙이후 하강
                    // 예시)
                    //    *
                    //   ***
                    //  *****   
                    //   ***    <- 여기부터 시작
                    //    *
                    for (int k = N - j - 1; k >= 1; k--) {
                        sum += map[j][point - k];
                        sum += map[j][point + k];
                    }
                }

            }
            sb.append("#").append(i + 1).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);

    }


}
