import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb;
    static int[] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[N];
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            map[i] = value;
        }
        nextPerm(N-1);

        System.out.println(sb);
    }

    private static void nextPerm(int size) {

        int i = size;
        while (i > 0 && map[i - 1] > map[i]) i--;

        if (i == 0) {
            sb.append(-1);
            return;
        }

        int j = size;

        while (map[i - 1] > map[j]) j--;

        int temp = map[i - 1];
        map[i - 1] = map[j];
        map[j] = temp;

        int f = size;
        while (i < f) {
            temp = map[i];
            map[i] = map[f];
            map[f] = temp;
            i++;
            f--;
        }

        for (int k = 0; k < N; k++) {
            sb.append(map[k]).append(" ");
        }

    }

}
