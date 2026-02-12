import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        
        for(int i=2; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + cur;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            sb.append(arr[e]-arr[s-1]).append("\n");
        }
        
        System.out.print(sb);
    }
}