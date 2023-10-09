package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11055 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());

        int[] numberList = new int[A];
        int[] dp = new int[A];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < A; i++) {
            int num = Integer.parseInt(st.nextToken());
            numberList[i] = num;
        }

        for (int i = 0; i < A; i++) {
            int nowValue = numberList[i];
            dp[i] = nowValue;
            for (int j = 0; j < i; j++) {

                if(numberList[j] < nowValue){
                    dp[i] = Math.max(dp[j]+nowValue,dp[i]);
                }
            }
        }

/*        for (int i = 0; i < dp.length; i++) {
            System.out.println("dp["+i+"] = " + dp[i]);
        }*/
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);

    }
}
