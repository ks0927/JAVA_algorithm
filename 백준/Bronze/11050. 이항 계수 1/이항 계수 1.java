import java.util.*;
import java.io.*;

public class Main {
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N + 1];
        map[0] = 1;
        map[1] = 1;
        getFactorial(N);

        System.out.println( map[N] / (map[N-K] * map[K]));
    }

    public static int getFactorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        if(map[n] != 0){
            return map[n];
        }
        return map[n] = (n) * getFactorial(n - 1);
    }
}
