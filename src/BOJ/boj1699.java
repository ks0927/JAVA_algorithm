package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] memo = new int[100001];

        Arrays.fill(memo,100001);

        memo[0] = 0;
        for (int i = 1; i <= 316; i++) {
            int pow = i * i;
            for (int j = pow; j <= 100000; j++) {
                memo[j] = Math.min(memo[j],memo[j-pow] + 1);
            }
        }

/*        for (int i = 0; i < memo.length; i++) {
            System.out.println("memo["+i+"] = " + memo[i]);
        }*/

        System.out.println(memo[N]);


    }
}
