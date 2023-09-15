package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj2217 {

    static int N;
    static Integer[] rope;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        rope = new Integer[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            rope[i] = a;
        }

        Arrays.sort(rope, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            max = Math.max(max, rope[i] * (i + 1));
        }

        System.out.println(max);

    }
}
