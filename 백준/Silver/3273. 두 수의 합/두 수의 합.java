import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        Arrays.sort(map);

        int leftIndex = 0;
        int rightIndex = N - 1;

        int cnt = 0;
        while (rightIndex > leftIndex) {
            int sum = map[leftIndex] + map[rightIndex];

            if (sum > X) {
                rightIndex--;
            }
            if (sum == X) {
                cnt++;
                leftIndex++;
                rightIndex--;
            }
            if (sum < X) {
                leftIndex++;
            }
        }

        System.out.println(cnt);

    }

}


