import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
                if (map[i][j] < minHeight) {
                    minHeight = map[i][j];
                }
            }
        }

        int time = Integer.MAX_VALUE;
        int height = Integer.MAX_VALUE;

        for (int h = minHeight; h <= maxHeight; h++) {
            //높이h를 달성하기 위해서 파야하는 블럭갯수
            int digCount = getDigCount(h, N, M);
            //높이h를 달성하기 위해서 쌓아야하는 블럭갯수
            int buildCount = getBuildCount(h, N, M);

            //만약 확보한 블럭 갯수가 쌓아야하는 블럭갯수 보다 작으면 불가능한 케이스
            if(digCount + B < buildCount) {
                break;
            }

            int tempTime = buildCount + digCount*2;

            if(tempTime < time) {
                time = tempTime;
                height = h;
            } else if (tempTime == time) {
                height = h;
            }
        }

        System.out.println(time+" "+ height);
    }

    private static int getDigCount(int h, int N, int M) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > h) {
                    count += (map[i][j] - h);
                }
            }
        }

        return count;
    }

    private static int getBuildCount(int h, int N, int M) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] < h) {
                    count += (h - map[i][j]);
                }
            }
        }

        return count;
    }


}
