import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(DFS(N, r, c, 0));
    }

    private static int DFS(int n, int r, int c, int sum) {
        if (n == 0) {
            return sum;
        }

        if (0 <= r && r < Math.pow(2, n - 1) && 0 <= c && c < Math.pow(2, n - 1)) {
            return DFS(n - 1, r, c, sum);
        }

        if (0 <= r && r < Math.pow(2, n - 1) && Math.pow(2, n - 1) <= c && c < Math.pow(2, n)) {
            return DFS(n - 1, r, c - (int) Math.pow(2, n - 1), sum + 1 * (int) Math.pow(2, n * 2 - 2));
        }

        if (Math.pow(2, n - 1) <= r && r < Math.pow(2, n) && 0 <= c && c < Math.pow(2, n - 1)) {
            return DFS(n - 1, r - (int) Math.pow(2, n - 1), c, sum + 2 * (int) Math.pow(2, n * 2 - 2));
        }

        if (Math.pow(2, n - 1) <= r && r < Math.pow(2, n) && Math.pow(2, n - 1) <= c && c < Math.pow(2, n)) {
            return DFS(n - 1, r - (int) Math.pow(2, n - 1), c - (int) Math.pow(2, n - 1),
                    sum + 3 * (int) Math.pow(2, n * 2 - 2));
        }

        return -1;
    }

}
