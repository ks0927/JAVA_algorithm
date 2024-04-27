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
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int parseInt = Integer.parseInt(st.nextToken());
                    map[j][k] = parseInt;
                }
            }

            int[][] rotation90 = rotation(map);
            int[][] rotation180 = rotation(rotation90);
            int[][] rotation270 = rotation(rotation180);

            sb.append("#").append(i + 1).append("\n");

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    sb.append(rotation90[j][k]);
                }
                sb.append(" ");

                for (int k = 0; k < N; k++) {
                    sb.append(rotation180[j][k]);
                }
                sb.append(" ");

                for (int k = 0; k < N; k++) {
                    sb.append(rotation270[j][k]);
                }
                sb.append("\n");
            }

        }
        System.out.print(sb);

    }

    static int[][] rotation(int[][] map) {
        int[][] result = new int[map.length][map.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                result[i][j] = map[map.length - j - 1][i];
            }
        }

        return result;
    }

}
