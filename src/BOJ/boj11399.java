package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11399 {

    static int N;
    static int result;
    static Integer[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        money = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            money[i] = a;
        }

        //오름차순으로 정렬해서 시간이 적게걸리는 사람먼저 뽑게한다.
        Arrays.sort(money);

        result = 0;
        for (int i = 0; i < money.length; i++) {

            int waiting = 0;
            for (int j = 0; j < i; j++) {
                waiting += money[j];
            }
            result += waiting;
            result += money[i];

//            System.out.println("result = " + result);
        }
        System.out.println(result);


    }
}
