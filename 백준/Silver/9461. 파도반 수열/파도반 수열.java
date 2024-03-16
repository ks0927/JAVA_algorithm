import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Long[] map = new Long[101];

        map[1] = 1L;
        map[2] = 1L;
        map[3] = 1L;

        for (int i = 4; i <= 100; i++) {
            map[i] = map[i - 2] + map[i - 3];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(map[N]).append("\n");
        }

        System.out.println(sb);

    }


}

