import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int T;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            BigInteger result = new BigInteger("1");
            for (int j = M; j > M - N; j--) {
                result = result.multiply(new BigInteger(String.valueOf(j)));
            }
            for (int j = 1; j <= N; j++) {
                result = result.divide(new BigInteger(String.valueOf(j)));
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);

    }


}
