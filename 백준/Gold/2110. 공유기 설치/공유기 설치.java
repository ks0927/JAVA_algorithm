import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int C;
    static int[] houses;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 1;
        int end = houses[N - 1] - houses[0] + 1;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;

            int cnt = 1;
            int locate = houses[0];

            for (int i = 1; i < N; i++) {
                int dist = houses[i] - locate;
                if(dist >= mid) {
                    cnt++;
                    locate = houses[i];
                }
            }

            if(cnt >= C) {
                start = mid +1;
            }else {
                end = mid;
            }
        }

        System.out.println(end - 1);
    }


}
