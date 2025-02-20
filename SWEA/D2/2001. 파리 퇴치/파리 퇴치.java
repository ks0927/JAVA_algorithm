import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int M;
    static int[][] map;
    static int[][] sumList;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            sumList = new int[N][N];
            initMap();

            int result = 0;
            for (int j = 0; j + M - 1 < N; j++) {
                for (int k = 0; k + M - 1 < N; k++) {
                    result = Math.max(result, partitionSum(j, k, j + M - 1, k + M - 1));
                }
            }

            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }

        System.out.println(sb);

    }

    private static void initMap() {

        // 가로 세로 초기화
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum += map[0][i];
            sumList[0][i] = sum;

            sum2 += map[i][0];
            sumList[i][0] = sum2;
        }

        // 나머지 부분 초기화
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                sumList[i][j] = sumList[i - 1][j] + sumList[i][j - 1] - sumList[i - 1][j - 1] + map[i][j];
            }
        }

    }

    private static int partitionSum(int r1, int c1, int r2, int c2) {
        int sum = sumList[r2][c2];

        if (r1 > 0)
            sum -= sumList[r1 - 1][c2];
        if (c1 > 0)
            sum -= sumList[r2][c1 - 1];
        if (r1 > 0 && c1 > 0)
            sum += sumList[r1 - 1][c1 - 1];

        return sum;
    }
}


