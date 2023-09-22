package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj20300 {

    static int N;
    static Long max;
    static Long result;
    static Long[] muscle;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        muscle = new Long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Long loss = Long.parseLong(st.nextToken());
            muscle[i] = loss;
        }

        //오름차순 정렬
        Arrays.sort(muscle);

        //N이 짝수일때는 i와 N-1-i 하고 짝을 짓는다.
        if(N % 2 == 0){
            max = 0L;
            for (int i = 0; i < N / 2; i++) {
                Long todayLoss = muscle[i] + muscle[N - 1 - i];
                if(max < todayLoss){
                    max = todayLoss;
                }
            }
        }
        //N이 홀수일때는 N-1 번째 를 제외해서 짝수로 만든뒤 짝을 짓는다.
        //대신 초기 max를 N-1번째로 둔다.
        else {
            max = muscle[N-1];
            for (int i = 0; i < N / 2; i++) {
                Long todayLoss = muscle[i] + muscle[N - 2 - i];
                if(max < todayLoss){
                    max = todayLoss;
                }
            }
        }

        result = max;

        System.out.println(result);
    }
}
