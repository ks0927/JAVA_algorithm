import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int X = Integer.parseInt(br.readLine());
        
        int s = 0;
        int e = N-1;
        
        int cnt = 0;
        while ( s < e ){
            int cur = arr[s] + arr[e];
            
            if(cur > X) {
                e--;
            }
            if(cur < X){
                s++;
            }
            if(cur == X){
                cnt++;
                e--;
                s++;
            }
        }
        
        System.out.println(cnt);
    }

}