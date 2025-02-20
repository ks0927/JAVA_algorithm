import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[6][2]; // r 방향 c 길이
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Long leftSize = 0L;
        for (int i = 0; i < 6; i++) {
            int afterR = (i + 2) % 6;
            if (map[i][0] == map[afterR][0]) {
                if (map[(i + 1) % 6][0] != map[(i + 3) % 6][0]) {
                    leftSize = Long.valueOf(map[i][1] * map[i + 1][1]);
                    break;
                }
                leftSize = Long.valueOf(map[(i + 1) % 6][1] * map[(i + 2) % 6][1]);
                break;
            }
        }

//        System.out.println("leftSize = " + leftSize);

        Long mainSize = 0L;
        for (int i = 0; i < 6; i++) {
            mainSize = Math.max(mainSize, Long.valueOf(map[i][1] * map[(i + 1) % 6][1]));
        }
//        System.out.println("mainSize = " + mainSize);

        Long result = (mainSize - leftSize) * K;
        System.out.println(result);
    }

}


