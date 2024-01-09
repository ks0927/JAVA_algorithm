import java.util.*;
import java.io.*;

public class Main {

    static Integer[][] map = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        map[0][0] = 1;
        map[0][1] = 0;
        map[1][0] = 0;
        map[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            fibo(n);
            sb.append(map[n][0]).append(" ").append(map[n][1]).append("\n");
        }

        System.out.println(sb);

    }

    private static Integer[] fibo(int n) {
        if(map[n][0] == null || map[n][1] == null) {
            map[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            map[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }
        return map[n];
    }

}
