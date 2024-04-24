import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][];

            for (int j = 0; j < N; j++) {
                map[j] = new int[j + 1];

                map[j][0] = 1;
                map[j][j] = 1;

                for (int k = 1; k < j; k++) {
                    map[j][k] = map[j - 1][k - 1] + map[j - 1][k];
                }
            }

            sb.append("#").append(i + 1).append("\n");

            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[j].length; k++) {
                    sb.append(map[j][k] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }


}
