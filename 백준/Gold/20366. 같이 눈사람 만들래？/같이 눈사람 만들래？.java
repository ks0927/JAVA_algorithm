import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] snow;
    static int min;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        snow = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snow);
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 3; i++) {
            for (int j = N - 1; j >= i + 3; j--) {
                int snowman1 = snow[i] + snow[j];

                int s = i + 1;
                int e = j - 1;

                while (s < e) {
                    int snowman2 = snow[s] + snow[e];
                    min = Math.min(min, Math.abs(snowman1 - snowman2));
                    if (snowman2 < snowman1) {
                        s++;
                    } else if (snowman2 > snowman1) {
                        e--;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(min);
    }


}
