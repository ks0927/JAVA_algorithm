import java.io.*;
import java.util.*;

public class Main {
    static int[] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[M];
        visited = new boolean[N + 1];

        DFS(N, M, 0);

        System.out.println(sb);
    }

    public static void DFS(int N, int M, int depth) {
        if (depth == M) {
            for (int value : map) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                map[depth] = i;
                DFS(N, M, depth + 1);
                visited[i] = false;
            }
        }

    }
}
