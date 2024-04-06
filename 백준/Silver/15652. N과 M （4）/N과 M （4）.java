import java.io.*;
import java.util.*;

public class Main {

    static int[] lines;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        lines = new int[M];

        DFS(N, M, 0, 1);

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

        for (int i = at; i <= N; i++) {
            lines[depth] = i;
            DFS(N, M, depth + 1, i);
        }


    }

}
