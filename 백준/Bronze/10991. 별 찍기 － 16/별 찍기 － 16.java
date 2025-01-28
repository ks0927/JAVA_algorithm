import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N - 1 - i; j++) {
                sb.append(" ");
            }
            sb.append("*");

            for (int j = 0; j < i; j++) {
                sb.append(" ").append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }


}
