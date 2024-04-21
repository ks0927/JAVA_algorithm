import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] map = new int[101];
            while (st.hasMoreTokens()) {
                int parseInt = Integer.parseInt(st.nextToken());
                map[parseInt] += 1;
            }
            int max = -1;
            int result = -1;
            for (int j = 0; j <= 100; j++) {
                if (map[j] >= max) {
                    max = map[j];
                    result = j;
                }
            }
            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }


}
