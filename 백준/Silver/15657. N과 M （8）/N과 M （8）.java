import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] map;
    static int[] pick;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];
        pick = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            map[i] = value;
        }

        sb = new StringBuilder();
        Arrays.sort(map);

        combi(0, 0);

        System.out.print(sb);
    }

    public static void combi(int depth, int start) {
        if (depth == M) {
            for (int value : pick) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            pick[depth] = map[i];
            combi(depth + 1, i);
            pick[depth] = 0;
        }

    }
}
