import java.io.*;
import java.util.*;

public class Main {

    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cnt = 0;

        Hanoi(N, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void Hanoi(int n, int start, int temp, int arrive) {
        if (n == 0)
            return;

        Hanoi(n - 1, start, arrive, temp);
        cnt++;
        sb.append(start).append(" ").append(arrive).append("\n");
        Hanoi(n - 1, temp, start, arrive);
    }

}