import java.util.*;
import java.io.*;

public class Main{
    public static boolean[] primeList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int answer = 0;
        setUpPrimeList(1000);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            int number = Integer.parseInt(st.nextToken());
            if(!primeList[number]){
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void setUpPrimeList(int N){
        primeList = new boolean[N+1];
        
        primeList[0] = true;
        primeList[1] = true;
        
        for(int i =2; i<= Math.sqrt(N); i++){
            if(primeList[i]){
                continue;
            }
            
            for(int j=i*i; j<=N ; j+=i){
                primeList[j] =true;
            }
        }
        
    }
}