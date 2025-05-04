import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] maps;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N + 1];
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());

            int[] temp = new int[K];
            for (int j = 0; j < K; j++) {
                int v = Integer.parseInt(st.nextToken());
                temp[j] = v;

                if (j != 0) {
                    maps[v] += 1;
                    adj[temp[j - 1]].add(v);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(true) {

            boolean flag = false;
            for (int i = 1; i <= N; i++) {
                if(maps[i] == 0 && !visited[i]) {
                    result.add(i);
                    visited[i] = true;
                    flag = true;
                    for (int j = 0; j < adj[i].size(); j++) {
                        maps[adj[i].get(j)] -= 1;
                    }
                }
            }

            if(!flag) {
                break;
            }
        }

        StringBuilder sb= new StringBuilder();
        if(result.size() < N) {
            System.out.println(0);
        }else {
            for (Integer i : result) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}



