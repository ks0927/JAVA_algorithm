package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj19941 {


    static int N;
    static int K;
    static int result;
    static String[] table;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = new String[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        for (int i = 0; i < N; i++) {
            String c = String.valueOf(s.charAt(i));
            table[i] = c;

            if(c.equals("H"))
                check[i] = true;

        }

        result = 0;
        // P 즉 사람일때 사람은 K만큼의 거리의 햄버거를 집을수있다.
        // 해당 범위는 i-K ~ i+k 까지 이다.
        // 즉 햄버거를 집을수있을때 가장 앞에있는거 부터 집는게 이번 그리디의 방식.
        for (int i = 0; i < N; i++) {
            if(table[i].equals("P")){
                int start = i - K;
                int end = i + K;
                for (int j = start; j <= end; j++) {
                    //index 범위를 넘어선다면 pass
                    if(!( 0<=j && j < N))
                        continue;

                    if(check[j]){
                        result++;
                        check[j] =false;
                        break;
                    }
                }
            }
        }

        System.out.println(result);

    }
}
