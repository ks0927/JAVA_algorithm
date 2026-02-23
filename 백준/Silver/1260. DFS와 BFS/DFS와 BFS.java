import java.util.*;
import java.io.*;

class Main {
    static int N,M,V;
    static int[][] map;
    static int[] visited;
    static ArrayList<Integer> bfs,dfs;
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        dfs = new ArrayList<>();
        visited = new int[N+1];
        
        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            map[s][e] = 1;
            map[e][s] = 1;
        }
        
        dfs.add(V);
        visited[V] = 1;
        dfs(V);

        for(int cur : dfs) {
            sb.append(cur).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("\n");

        bfs = new ArrayList<>();
        visited = new int[N+1];
        bfs(V);
        for(int cur : bfs) {
            sb.append(cur).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    }
    
    public static void dfs(int cur) {
  
        for(int i=1; i <= N; i++) {
            if(map[cur][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                dfs.add(i);
                dfs(i);
            }
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        
        while(!que.isEmpty()) {
            int size = que.size();
            
            for(int i=0; i < size; i++) {
                int cur = que.poll();
                bfs.add(cur);
                visited[cur] = 1;
                
                for(int j=1; j <= N; j++) {
                    if(map[cur][j] == 1 &&visited[j] == 0) {
                        que.add(j);
                        visited[j] = 1;
                    }
                }
            }
        }
    }
}