import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());
        map = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int Xdirect = Integer.parseInt(st.nextToken());
        int Xc = Integer.parseInt(st.nextToken());

        int sum = 0;

        for (int i = 0; i < T; i++) {
            sum += findDistance(i, Xdirect, Xc);
        }

        System.out.println(sum);
    }

    private static int findDistance(int index, int xdirect, int xc) {
        int distance;
        int md = map[index][0];
        int mc = map[index][1];

        // 같은 방향일 경우
        if (xdirect == md) {
            distance = Math.abs(xc - mc);
        }
        // 반대 방향일 경우 (북1-남2, 동4-서3)
        else if ((xdirect == 1 && md == 2) || (xdirect == 2 && md == 1)) {
            distance = Math.min(xc + N + mc, (M - xc) + N + (M - mc));
        }
        else if ((xdirect == 3 && md == 4) || (xdirect == 4 && md == 3)) {
            distance = Math.min(xc + M + mc, (N - xc) + M + (N - mc));
        }
        // 직각으로 만나는 경우
        else {
            if (xdirect == 1) { // 북
                if (md == 3) distance = xc + mc;
                else distance = (M - xc) + mc;
            }
            else if (xdirect == 2) { // 남
                if (md == 3) distance = xc + (N - mc);
                else distance = (M - xc) + (N - mc);
            }
            else if (xdirect == 3) { // 서
                if (md == 1) distance = xc + mc;
                else distance = (N - xc) + mc;
            }
            else { // 동
                if (md == 1) distance = xc + (M - mc);
                else distance = (N - xc) + (M - mc);
            }
        }

        return distance;
    }

}
