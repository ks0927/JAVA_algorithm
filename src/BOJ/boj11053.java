package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11053 {

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
            // 기본초기화는 1, 원소가 본인뿐인 부분수열부터 시작하는걸로 생각.
            dp[i] = 1;

            //자기보다 작은 값들을 보면서 이어붙였을때 값하고 현재값하고 비교해서 max로 초기화
            for (int j = 0; j < i; j++) {
                if(numberList[j] < numberList[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

        }

/*        for (int i = 0; i < A; i++) {
            System.out.println(dp[i]);
        }*/

        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);

    }
}
