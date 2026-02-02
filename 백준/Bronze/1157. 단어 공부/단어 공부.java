import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine().toUpperCase();
        
        int[] map = new int[26];
        int max = 0;
        
        for(int i=0; i < str.length(); i++) {
            int cur = str.charAt(i) - 'A';
            map[cur]+=1;
            if(max < map[cur]) {
                max = map[cur];
            }
        }       
        
        int cnt = 0;
        char result = '?';
        
        for(int i = 0; i < 26; i++) {
            if(map[i] == max) {
                
                // 이미 발견한 중복이라면
                if(result != '?') {
                    result = '?';
                    break;
                }
                
                result = (char)('A' + i);
            }
        }

        System.out.println(result);

    }
}