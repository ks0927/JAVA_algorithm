import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int calculate = calculate(k, n);
            sb.append(calculate).append("\n");
        }
        System.out.println(sb);

    }

    private static int calculate(int k, int n) {
        if (k == 0) {
            return n;
        }
        if (n == 1) {
            return 1;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int calculate = calculate(k - 1, i);
            result += calculate;
        }
        return result;
    }
}
