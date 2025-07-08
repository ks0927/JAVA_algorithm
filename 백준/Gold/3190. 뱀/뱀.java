import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    //우 하 좌 상
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static String[] rotate;

    static List<int[]> snake;
    static int time;
    static int direct;

    static boolean flag;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1;
        }

        rotate = new String[10001];


        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            String ro = st.nextToken();

            rotate[x] = ro;
        }

        snake = new ArrayList<>();
        snake.add(new int[] {0,0});
        time = 0;
        flag = false;
        direct = 0;
        map[0][0] = 2;

        while(!flag) {

            time++;
            //머리 이동
            int hr = snake.get(snake.size()-1)[0] + dr[direct];
            int hc = snake.get(snake.size()-1)[1] + dc[direct];

            //맵 밖으로 나가면 끝
            if(!check(hr,hc)) break;

            //내 몸에 닿으면 끝
            if(map[hr][hc] == 2) break;

            // 머리 이동한거 집어넣음
            snake.add(new int[] {hr,hc});

            //사과가 없다면
            if(map[hr][hc] == 0) {
                // 꼬리 맵에서 지우고
                map[snake.get(0)[0]][snake.get(0)[1]] = 0;
                // 꼬리 지움
                snake.remove(0);
            }

            //맵에 머리 표시
            map[hr][hc] = 2;

            if(rotate[time] != null) {

                if(rotate[time].equals("D")) {
                    direct = (direct + 1) % 4;
                }

                if(rotate[time].equals("L")) {
                    direct = (direct + 3) % 4;
                }
            }

        }

        System.out.println(time);

    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}
