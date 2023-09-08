package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11403 {

    static int N;
    static int[][] map;
    static int[][] resultMap;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        resultMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;

            }
        }

/*        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

/*        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1){

                    if(resultMap[i][j]==1)
                        continue;

                    visited = new int[N];
                    DFS(j);
                    resultMap[i] = new int[N];
                    resultMap[i] = Arrays.copyOf(visited,N);
                }
            }
        }*/

        //노드 기준으로 dfs
        for (int i = 0; i < N; i++) {
            visited = new int[N];
            DFS(i);
            for(int j=0;j<N;j++){
                if(visited[j]==1)
                    resultMap[i][j]=1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(resultMap[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void DFS(int node){

        for (int i = 0; i < N; i++) {

            if(visited[i] != 0)
                continue;

            if(map[node][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                DFS(i);
            }
        }
    }
}
