package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11727 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        if(N == 1){
            System.out.println(1);
            return;
        }
        if(N == 2){
            System.out.println(3);
            return;
        }

        Long[] memo = new Long[N+1];

        memo[1] = 1L;
        memo[2] = 3L;

        for (int i = 3; i <= N; i++) {
            Long curValue = ( memo[i - 1] + (memo[i - 2]*2) ) % 10007;
            memo[i] = curValue;
        }

        System.out.println(memo[N]);
    }
}
