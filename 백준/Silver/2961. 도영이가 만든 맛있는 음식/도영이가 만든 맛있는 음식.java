import java.io.*;
import java.util.*;

public class Main {

    static int[] sinArr;
    static int[] ssunArr;
    static boolean[] visited;
    static int N;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        sinArr = new int[N];
        ssunArr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sin = Integer.parseInt(st.nextToken());
            int sun = Integer.parseInt(st.nextToken());

            sinArr[i] = sin;
            ssunArr[i] = sun;

        }
        min = Integer.MAX_VALUE;
        set(0);

        System.out.println(min);
    }

    public static void set(int depth) {
        if (depth == N) {

            boolean checkBlank = false;
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    checkBlank = true;
            }

            if (checkBlank) {
                int sum = 0;
                int sins = 1;
                int ssuns = 0;

                for (int i = 0; i < N; i++) {
                    if (visited[i]) {
                        sins *= sinArr[i];
                        ssuns += ssunArr[i];
                    }
                }
                sum = Math.abs(sins - ssuns);
                min = Math.min(sum, min);
            }
            return;
        }

        visited[depth] = true;
        set(depth + 1);
        visited[depth] = false;
        set(depth + 1);
    }
}
