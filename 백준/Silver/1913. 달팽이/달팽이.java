import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int N;
    static int M;
    static int R;
    static int C;

    // 하 우 상 좌
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        fill();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        System.out.print(R + " " + C);
    }

    public static void fill() {
        int r = 0;
        int c = 0;
        int num = N * N;
        int turn = 0; // 방향을 위한 변수. 0하 1우 2상 3좌

        while (num > 0) {
            arr[r][c] = num;

            if (num == M) {
                R = r + 1;
                C = c + 1;
            }
            num--;

            //방향전환
            int nr = r + dr[turn];
            int nc = c + dc[turn];
            if (!(nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0)) { //만약 현재 turn 방향으로 갈수없다면(이미갔다면)
                turn = (turn + 1) % 4;  //방향을 꺾는다.
                nr = r + dr[turn];   //꺾인 다음방향으로 nr과 nc를 재초기화
                nc = c + dc[turn];
            }

            r = nr;
            c = nc;
        }

    }

}
