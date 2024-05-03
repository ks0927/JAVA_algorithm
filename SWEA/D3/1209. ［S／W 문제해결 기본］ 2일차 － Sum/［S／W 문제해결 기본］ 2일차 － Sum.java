import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(br.readLine());

            int[][] map = new int[100][100];

            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[j][k] = value;
                }
            }

            int max = 0;
            //가로
            for (int j = 0; j < 100; j++) {
                int sum = 0;
                for (int k = 0; k < 100; k++) {
                    sum += map[j][k];
                }
                if (sum > max)
                    max = sum;
            }
            //세로
            for (int j = 0; j < 100; j++) {
                int sum = 0;
                for (int k = 0; k < 100; k++) {
                    sum += map[k][j];
                }
                if (sum > max)
                    max = sum;
            }

            //대각선 ->
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += map[j][j];
            }
            if (sum > max)
                max = sum;

            //대각선  <-
            sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += map[j][99 - j];
            }
            if (sum > max)
                max = sum;

            sb.append("#").append(i + 1).append(" ").append(max).append("\n");
        }
        System.out.print(sb);

    }


}
