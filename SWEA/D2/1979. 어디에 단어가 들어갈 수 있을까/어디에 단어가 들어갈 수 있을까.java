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
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];


            // 초기화
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int parseInt = Integer.parseInt(st.nextToken());
                    map[j][k] = parseInt;
                }
            }

            int result = getResult(N, map, K);

            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    static int getResult(int N, int[][] map, int K) {
        int result = 0;

        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int k = 0; k < N; k++) {
                if (map[j][k] == 1) {
                    count++;
                    continue;
                }

                if (map[j][k] == 0) {
                    if (count == K) {
                        result++;
                    }
                    count = 0;
                }
            }
            if (count == K) {
                result++;
            }
        }

        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int k = 0; k < N; k++) {
                if (map[k][j] == 1) {
                    count++;
                    continue;
                }

                if (map[k][j] == 0) {
                    if (count == K) {
                        result++;
                    }
                    count = 0;
                }
            }
            if (count == K) {
                result++;
            }
        }
        return result;
    }

}