package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj11508 {
    static int N;
    static Long result;
    static Integer[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        price = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            price[i] = a;
        }

        //내림차순으로 가격들을 정렬한다.
        Arrays.sort(price, Collections.reverseOrder());

        result =0L;
        //3번째 마다 안더하고 continue
        for (int i = 1; i <= price.length; i++) {
            if( (i % 3 == 0) && i != 0)
                continue;

            result+= price[i-1];
        }

        System.out.println(result);
    }
}
