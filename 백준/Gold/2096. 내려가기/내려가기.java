import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            map[i][0] = first;
            map[i][1] = second;
            map[i][2] = third;
        }

        int min = getMin(N, map);
        int max = getMax(N, map);

        sb.append(max).append(" ").append(min).append("\n");

        System.out.print(sb);

    }

    public static int getMin(int N, int[][] map) {
        int[][] minMap = new int[N][3];
        minMap[0][0] = map[0][0];
        minMap[0][1] = map[0][1];
        minMap[0][2] = map[0][2];

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 3; j++) {

                if (j == 0) {
                    minMap[i + 1][j] = Math.min(minMap[i][j] + map[i + 1][j], minMap[i][j + 1] + map[i + 1][j]);
                }
                if (j == 1) {
                    int temp = Math.min(minMap[i][j - 1], minMap[i][j]);
                    int minTemp = Math.min(temp, minMap[i][j + 1]);

                    minMap[i + 1][j] = minTemp + map[i + 1][j];
                }
                if (j == 2) {
                    minMap[i + 1][j] = Math.min(minMap[i][j] + map[i + 1][j], minMap[i][j - 1] + map[i + 1][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (min > minMap[N - 1][i])
                min = minMap[N - 1][i];
        }
        return min;
    }

    public static int getMax(int N, int[][] map) {
        int[][] maxMap = new int[N][3];
        maxMap[0][0] = map[0][0];
        maxMap[0][1] = map[0][1];
        maxMap[0][2] = map[0][2];

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 3; j++) {

                if (j == 0) {
                    maxMap[i + 1][j] = Math.max(maxMap[i][j] + map[i + 1][j], maxMap[i][j + 1] + map[i + 1][j]);
                }
                if (j == 1) {
                    int temp = Math.max(maxMap[i][j - 1], maxMap[i][j]);
                    int maxTemp = Math.max(temp, maxMap[i][j + 1]);

                    maxMap[i + 1][j] = maxTemp + map[i + 1][j];
                }
                if (j == 2) {
                    maxMap[i + 1][j] = Math.max(maxMap[i][j] + map[i + 1][j], maxMap[i][j - 1] + map[i + 1][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (max < maxMap[N - 1][i])
                max = maxMap[N - 1][i];
        }
        return max;
    }
}
