import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] mems;
    static int[] times;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mems = new int[N];
        times = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mems[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[10001];
        for (int i = 0; i < N; i++) {

            int nowMem = mems[i];
            int nowTime = times[i];

            for (int j = 10000; j >= nowTime; j--) {
                dp[j] = Math.max(dp[j], dp[j - nowTime] + nowMem);
            }
        }

//        System.out.println(Arrays.toString(dp));

        for (int i = 0; i < 10001; i++) {
            if(dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
