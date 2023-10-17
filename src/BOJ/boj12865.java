package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj12865 {

    static class Items{
        int weight;
        int value;

        public Items(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        List<Items> itemsList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            itemsList.add(new Items(W,V));
        }


/*        for (int t = 0; t <= K; t++) {
            System.out.print(t+" ");
        }
        System.out.println();
        System.out.println("--------------------------------");*/
        for (int i = 0; i < N; i++) {
            Items items = itemsList.get(i);
            int weight = items.weight;
            int value = items.value;
            
            for (int j = K; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }

/*            for (int j = weight; j <= K; j++) {
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }*/

/*            for (int t = 0; t <= K; t++) {
                System.out.print(dp[t]+" ");
            }
            System.out.println();*/
        }

/*        System.out.println("end");
        for (int i = 0; i <= K; i++) {
            System.out.print(dp[i]+" ");
        }*/

        int asInt = Arrays.stream(dp).max().getAsInt();

        System.out.println(asInt);
    }
}
