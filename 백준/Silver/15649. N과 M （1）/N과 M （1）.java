import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[] p,visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        p = new int[M];
        visited = new int[N+1];
        sb = new StringBuilder();
        
        perm(0);
        
        System.out.print(sb);
    }
    
    public static void perm(int depth) {
        if(depth == M) {
            
            for(int i= 0; i < M-1; i++) {
                sb.append(p[i]).append(" ");
            }
            sb.append(p[M-1]);
            sb.append("\n");
            
            return;
        }
        
        for(int i=1; i <= N; i++) {
            if(visited[i] ==1) continue;
                
            visited[i] = 1;
            p[depth] = i;
            perm(depth+1);
            visited[i] = 0;
            
        }
    }
}