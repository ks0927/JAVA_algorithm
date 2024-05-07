import java.io.*;
import java.util.*;

public class Solution {

    static boolean[] visited;
    static List<Integer>[] graph;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (M == 0) {
                sb.append("#").append(i + 1).append(" ").append(1).append("\n");
                continue;
            }

            graph = new List[N + 1];
            visited = new boolean[N + 1];

            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            max = 1;
            for (int j = 1; j <= N; j++) {
                visited[j] = true;
                DFS(j, 1);
                visited[j] = false;
            }

            sb.append("#").append(i + 1).append(" ").append(max).append("\n");
        }

        System.out.print(sb);

    }

    static void DFS(int node, int distance) {
        if(distance > max) {
            max = distance;
        }

        for (Integer next : graph[node]) {
            if(!visited[next]) {
                visited[next] = true;
                DFS(next, distance + 1);
                visited[next] =false;
            }
        }
    }


}
