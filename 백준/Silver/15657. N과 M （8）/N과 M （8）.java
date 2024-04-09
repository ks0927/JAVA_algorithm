import java.io.*;
import java.util.*;

public class Main {

    static int[] lines;
    static int[] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N];
        lines = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        DFS(N, M, 0, 0);

        System.out.println(sb);
    }

    static void DFS(int N, int M, int depth, int at) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(lines[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < N; i++) {
            lines[depth] = map[i];
            DFS(N, M, depth + 1, i);
        }
    }


}
