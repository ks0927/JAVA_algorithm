import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] bag = new int[2];
        bag[0] = 5;
        bag[1] = 3;


        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE -1);
        dp[0] = 0;

        for(int i = 0; i < bag.length; i++){
            for(int j = 0; j< dp.length; j++){
                if(0<=j-bag[i] && j-bag[i]<=N){
                    dp[j] = Math.min(dp[j-bag[i]]+1,dp[j]);
                }
            }
        }

        if(dp[N] == Integer.MAX_VALUE-1){
            System.out.println(-1);
        }else{
            System.out.println(dp[N]);
        }
    }
}