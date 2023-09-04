package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503 {

    static int[][] map;
    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] check;
    static int N;
    static int M;
    static int R;
    static int C;
    static int D;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        int solution = solution(R, C, D);
        System.out.println(solution);


    }
    static int solution(int r, int c, int d){
        int result =0;

        while(true){
            //현재칸이 청소되지 않았다면
            if(map[r][c] ==0 && !check[r][c]){
                check[r][c] = true;
                ++result;
            }
            boolean isDirty = nearByCheck(r, c);

            //주변 4방향에 청소안된곳이 없을때
            if(isDirty==false){
                //뒤로 갈수있으면
                int[] checkGoBack = canGoBack(r, c, d);
                if(checkGoBack[2]==1){
                    r = checkGoBack[0];
                    c = checkGoBack[1];

                    continue;
                }
                else if(checkGoBack[2]==0)
                    break;

            }
            //주변 4방향에 청소안된곳이 있을때
            if(isDirty==true){
                while (true) {
                    int[] rotate = rotate(r, c, d);
                    d = rotate[2];

                    //회전후 앞칸이 청소되지않았다면 전진
                    if (rotate[3]==1){
                        r = rotate[0];
                        c = rotate[1];
                        d = rotate[2];
                        break;
                    }

                }
            }
        }
        
        return result;

    }

    //주변 4방향에 갈수있고 아직 청소가 안된곳이 있나 체크
    static boolean nearByCheck(int r, int c){
        boolean dirty = false;
        // 사방 탐색
        for (int i = 0; i < 4; i++) {
            int next_r = r + direction[i][0];
            int next_c = c + direction[i][1];

            if(!(0<= next_r && next_r<N && 0<= next_c && next_c<M)) continue;

            if(map[next_r][next_c]==0 && !check[next_r][next_c]){
                dirty = true;
                return dirty;
            }
        }
        return dirty;

    }

    //뒤로 갈수있는지 체크
    //result 배열은 [0]뒤로갈r값 ,[1]뒤로갈c값, [2]뒤로갈수있는가(0이면X 1이면O)
    static int[] canGoBack(int r, int c , int d){
        int[] result = new int[3];
        int back_r;
        int back_c;

        result[2] =0; //초기값

        switch (d){
            case 0:
                back_r = r+1;
                back_c = c;
                if((0<= back_r && back_r<N && 0<= back_c && back_c<M) && map[back_r][back_c]==0) {
                    result[0]=back_r;
                    result[1]=back_c;
                    result[2]=1;
                }

                break;
            case 1:
                back_r = r;
                back_c = c-1;
                if((0<= back_r && back_r<N && 0<= back_c && back_c<M) && map[back_r][back_c]==0) {
                    result[0]=back_r;
                    result[1]=back_c;
                    result[2]=1;
                }

                break;
            case 2:
                back_r = r-1;
                back_c = c;
                if((0<= back_r && back_r<N && 0<= back_c && back_c<M) && map[back_r][back_c]==0) {
                    result[0]=back_r;
                    result[1]=back_c;
                    result[2]=1;
                }

                break;
            case 3:
                back_r = r;
                back_c = c+1;
                if((0<= back_r && back_r<N && 0<= back_c && back_c<M) && map[back_r][back_c]==0) {
                    result[0]=back_r;
                    result[1]=back_c;
                    result[2]=1;
                }

                break;

        }

        return result;
    }

    //반시계로 회전하는 메소드
    //result 배열은 [0]앞으로갈r값 ,[1]앞으로갈c값, [2]회전한d값, [3]앞로갈수있는가(0이면X 1이면O)
    static int[] rotate(int r, int c, int d){
        int front_r;
        int front_c;
        int rotate_d;
        int[] result = new int[4];

        result[3] = 0; //초기값

        switch (d){
            case 0:
                rotate_d = 3;
                result[2]=rotate_d; //회전을 먼저 시킨다.
                front_r = r;
                front_c = c-1;
                //맵 내부이면서 맵이0이고 아직 안가봤으면 앞으로 이동
                if((0<= front_r && front_r<N && 0<= front_c && front_c<M) && map[front_r][front_c]==0 && !check[front_r][front_c]) {
                    result[0]=front_r;
                    result[1]=front_c;
                    result[2]=rotate_d;
                    result[3]=1;
                }

                break;
            case 1:
                rotate_d = 0;
                result[2]=rotate_d;//회전을 먼저 시킨다.
                front_r = r-1;
                front_c = c;
                if((0<= front_r && front_r<N && 0<= front_c && front_c<M) && map[front_r][front_c]==0 && !check[front_r][front_c]) {
                    result[0]=front_r;
                    result[1]=front_c;
                    result[2]=rotate_d;
                    result[3]=1;
                }

                break;
            case 2:
                rotate_d = 1;
                result[2]=rotate_d;//회전을 먼저 시킨다.
                front_r = r;
                front_c = c+1;
                if((0<= front_r && front_r<N && 0<= front_c && front_c<M) && map[front_r][front_c]==0 && !check[front_r][front_c]) {
                    result[0]=front_r;
                    result[1]=front_c;
                    result[2]=rotate_d;
                    result[3]=1;
                }

                break;
            case 3:
                rotate_d = 2;
                result[2]=rotate_d;//회전을 먼저 시킨다.
                front_r = r+1;
                front_c = c;
                if((0<= front_r && front_r<N && 0<= front_c && front_c<M) && map[front_r][front_c]==0 && !check[front_r][front_c]) {
                    result[0]=front_r;
                    result[1]=front_c;
                    result[2]=rotate_d;
                    result[3]=1;
                }

                break;

        }
        return result;
    }
}
