import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        BigInteger a = new BigInteger("2");
        BigInteger K = a.pow(N).subtract(new BigInteger("1"));
        System.out.println(K);
        if (N <= 20) {
            Hanoi(N, 1, 2, 3);
        }
        System.out.print(sb);
    }

    private static void Hanoi(int n, int start, int temp, int dest) {
        if (n == 0) return;

        Hanoi(n - 1, start, dest, temp);
        sb.append(start).append(" ").append(dest).append("\n");
        Hanoi(n - 1, temp, start, dest);

    }


}
