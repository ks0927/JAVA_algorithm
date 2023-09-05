package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260 {

    static int N;
    static int M;
    static int V;
    static int[][] map;
    static ArrayList<Integer> dfsValue;
    static ArrayList<Integer> bfsValue;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        dfsValue = new ArrayList<>();
        bfsValue = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }
        DFS(V);
        for (Integer integer : dfsValue) {
            System.out.print(integer+" ");
        }

        System.out.println();
        visited = new boolean[N+1];
        BFS(V);
        for (Integer integer : bfsValue) {
            System.out.print(integer+" ");
        }

    }
    static void DFS(int n){
        dfsValue.add(n);
        visited[n] = true;
        for (int i = 1; i <= N; i++) {

            if(map[n][i]==1 && !visited[i]){
                DFS(i);
            }
        }
    }
    static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        bfsValue.add(n);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ++level;
            Integer poll = queue.poll();
            for (int i = 0; i < size; i++) {
                for (int j = 1; j <= N; j++) {
                    if(map[poll][j]==1 && !visited[j]){
                        queue.add(j);
                        visited[j] = true;
                        bfsValue.add(j);
                    }
                }
            }
        }

    }
}
