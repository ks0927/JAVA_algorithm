import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int T;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int angle = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[j][k] = value;
                }
            }
            rotate(angle);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    sb.append(map[j][k] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);

    }

    public static void rotate(int angle) {
        int play = 0;
        if (angle < 0) {
            play = (angle + 360) / 45;
        } else {
            play = angle / 45;
        }

        int[][] temp = new int[map.length][map.length];

        for (int i = 0; i < play; i++) {
            //가로줄
            for (int j = 0; j < N; j++) {
                temp[(N / 2) + (j - N / 2)][j] = map[N / 2][j];
            }

            //세로줄
            for (int j = 0; j < N; j++) {
                temp[j][(N / 2) + (N / 2 - j)] = map[j][N / 2];
            }

            //주 대각선
            for (int j = 0; j < N; j++) {
                temp[j][N / 2] = map[j][j];
            }

            //부 대각선
            for (int j = 0; j < N; j++) {
                temp[N / 2][j] = map[N - 1 - j][j];
            }

            //map 재초기화
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (temp[j][k] != 0) {
                        map[j][k] = temp[j][k];
                    }
                }
            }

        }

    }


}
