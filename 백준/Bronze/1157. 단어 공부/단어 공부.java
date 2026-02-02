import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine().toUpperCase();
        
        int[] map = new int[26];
        
        for(int i=0; i < str.length(); i++) {
            int cur = str.charAt(i) - 'A';
            map[cur]+=1;
        }
        
        int max = 0;
        
        for(int i=0; i < 26; i++) {
            if(map[i] > max) {
                max = map[i];
            }
        }
        
        int cnt = 0;
        int idx = -1;
        for(int i = 0; i < 26; i++) {
            if(map[i] == max) {
                cnt++;
                idx = i;
            }
            
            if(cnt >= 2) {
                System.out.println("?");
                return;
            }
        }
        
        int result = 'A' + idx;
        System.out.printf("%c",result);

    }
}