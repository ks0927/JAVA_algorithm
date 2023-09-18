package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj11047 {

    static int N;
    static int K;
    static Integer[] coin;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new Integer[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            coin[i] = a;
        }

        //내림차순으로 정렬
        Arrays.sort(coin, Collections.reverseOrder());

        int count = 0;

        //K원 보다 작거나 같은 동전이면 거슬러 줄수있다.
        for (int i = 0; i < coin.length; i++) {
            if(coin[i] <= K){
                //갯수만큼 더해주고
                int addCoin = K / coin[i];
                count+= addCoin;
                //남은금액 초기화
                K = K % coin[i];
            }
        }

        System.out.println(count);

    }
}
