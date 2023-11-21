import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        if(N==1){
            System.out.println(1);
            return;
        }
        
        int answer =1;
        int border = 1;
        int flag = 6;
        while(true){
            answer++;
            border+=flag;
            
            if(N<=border){
                break;
            }
            flag+=6;
        }
        System.out.println(answer);
    }
    
}