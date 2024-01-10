import java.util.*;
import java.io.*;

public class Main {

    static final int LIMIT = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] map = new int[N + 1];
        map[0] = 0;
        map[1] = 0;

        for (int i = 2; i <= N; i++) {
            int sum = LIMIT;
            if (i % 3 == 0) {
                sum = Math.min(sum, map[i / 3] + 1);
            }
            if (i % 2 == 0) {
                sum = Math.min(sum, map[i / 2] + 1);
            }
            sum = Math.min(sum, map[i - 1] + 1);
            map[i] = sum;
        }

        System.out.println(map[N]);

    }

}
