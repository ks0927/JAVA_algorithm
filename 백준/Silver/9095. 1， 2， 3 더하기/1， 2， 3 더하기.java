import java.util.*;
import java.io.*;

public class Main {

    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        map = new int[11];
        map[0] = 1;
        map[1] = 1;
        map[2] = 2;
        map[3] = 4;

        dp();
        for (int i = 0; i < T; i++) {
            int parseInt = Integer.parseInt(br.readLine());
            sb.append(map[parseInt]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dp() {
        for (int i = 4; i < 11; i++) {
            map[i] = map[i-1] + map[i-2] + map[i-3];
        }
    }

}
