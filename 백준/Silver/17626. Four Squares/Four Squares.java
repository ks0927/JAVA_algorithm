import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N + 1];
        map[0] = 0;
        map[1] = 1;
        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, map[i - j * j]);
            }

            map[i] = min + 1;
        }

        System.out.println(map[N]);
    }


}
