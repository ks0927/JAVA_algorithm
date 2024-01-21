import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

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

        Arrays.sort(coin, Collections.reverseOrder());

        int count = 0;
        for (int i = 0; i < coin.length; i++) {
            if(coin[i] <= K){
                int addCoin = K / coin[i];
                count+= addCoin;
                K = K % coin[i];
            }
        }

        System.out.println(count);

    }
}
