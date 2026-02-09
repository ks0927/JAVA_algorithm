import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        
        HashMap<String,Integer> map = new HashMap<>();
        String[] map2 = new String[N+1];
        for(int i=1; i <= N; i++) {
            String pocket = br.readLine();
            map.put(pocket,i);
            map2[i] = pocket;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < M; i++) {
            String op = br.readLine();
            if(Character.isDigit(op.charAt(0))) {
                int a = Integer.parseInt(op);
                sb.append(map2[a]).append("\n");
                
            }else{
                sb.append(map.get(op)).append("\n");
            }
        }
        System.out.print(sb);
    }
}