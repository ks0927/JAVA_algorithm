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

            int[] map = new int[N];
            for (int j = 0; j < N; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                map[j] = parseInt;
            }

            int max = -1;
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    max = Math.max(max, check(map[j] * map[k]));
                }
            }

            sb.append("#").append(i + 1).append(" ").append(max).append("\n");
        }

        System.out.print(sb);

    }

    static int check(int value) {
        String str = String.valueOf(value);

        int temp = -1;
        for (int i = 0; i < str.length(); i++) {
            int parseInt = str.charAt(i) - '0';
            if (parseInt < temp) {
                return -1;
            }
            temp = parseInt;
        }
        return value;
    }

}
