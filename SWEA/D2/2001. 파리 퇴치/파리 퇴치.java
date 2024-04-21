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

            int[][] map = new int[N][N];

            int max = 0;

            // 초기화
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int parseInt = Integer.parseInt(st.nextToken());
                    map[j][k] = parseInt;
                }
            }

            for (int markY = 0; markY + M - 1 < N; markY++) {

                for (int markX = 0; markX + M - 1 < N; markX++) {

                    int sum = sumAround(markX, markY, M, map);

                    if (sum > max) {
                        max = sum;
                    }
                }
            }

            sb.append("#").append(i + 1).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    static int sumAround(int markX, int markY, int m, int[][] map) {
        int sum = 0;

        for (int i = markY; i < markY + m; i++) {
            for (int j = markX; j < markX + m; j++) {
                sum += map[i][j];
            }
        }

        return sum;
    }


}
