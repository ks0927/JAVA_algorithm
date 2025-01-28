import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2 * N - 1; i++) {

            for (int k = 0; k <N - Math.abs(i - (N - 1)); k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }


}
