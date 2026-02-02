import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int min = 1000001;
        int max = -1000001;
        
        for(int i = 0 ; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur < min) min = cur;
            if(cur > max) max = cur;
        }
        
        System.out.println(min+" "+max);
        
    }
}