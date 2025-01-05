import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int parseInt = Integer.parseInt(st.nextToken());
                    arr[j][k] = parseInt;
                }
            }
            int max = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    max = Integer.max(max, calculate(arr, j, k));
                }
            }

            sb.append("#").append(i + 1).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    public static int calculate(int[][] arr, int R, int C) {
        int move = M - 1;

        int moveR = R;
        int moveC = C;

        // +로 분사
        int sumPlus = arr[moveR][moveC];
        int[] directionPlusR = {1, -1, 0, 0};
        int[] directionPlusC = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            moveR = R;
            moveC = C;

            for (int j = 1; j <= move; j++) {
                moveR += directionPlusR[i];
                moveC += directionPlusC[i];

                if (invalid(moveR, moveC)) {
                    break;
                }

                sumPlus += arr[moveR][moveC];
            }
        }

        moveR = R;
        moveC = C;

        // X로 분사
        int sumX = arr[moveR][moveC];
        int[] directionXR = {1, 1, -1, -1};
        int[] directionXC = {-1, 1, -1, 1};

        for (int i = 0; i < 4; i++) {
            moveR = R;
            moveC = C;

            for (int j = 1; j <= move; j++) {
                moveR += directionXR[i];
                moveC += directionXC[i];

                if (invalid(moveR, moveC)) {
                    break;
                }

                sumX += arr[moveR][moveC];
            }
        }

        return (sumPlus > sumX) ? sumPlus : sumX;
    }

    public static boolean invalid(int R, int C) {
        if (R >= 0 && R < N && C >= 0 && C < N) {
            return false;
        }
        return true;
    }
}
