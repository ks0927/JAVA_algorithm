package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17144 {

    static int R;
    static int C;
    static int T;
    static int result;
    static int[][] map;
    static int[][] newMap;
    static int[] machine; //0에는 윗청소기 , 1에는 아랫청소기
    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        machine = new int[2];
        map = new int[R][C];

        newMap = new int[R][C];

        int machineIndex = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a == -1){
                    machine[machineIndex] = i;
                    machineIndex++;
                }
            }
        }
/*        for (int i : machine) {
            System.out.println("i = " + i);
        }*/

        for (int i = 0; i < T; i++) {
            spreadDust();
            operationMachine();
        }

        result = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
//                System.out.print(map[i][j]);
                if(map[i][j]>0)
                    result+=map[i][j];
            }
//            System.out.println();
        }

        System.out.println(result);

    }

    static void spreadDust() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int curDustValue = map[i][j];
                if(curDustValue > 0){
                    int canSpreadCount = 0;
                    int spreadDustValue = curDustValue / 5;

                    for (int k = 0; k < 4; k++) {//위 아래 왼쪽 오른쪽 탐색
                        int next_r = i + direction[k][0];
                        int next_c = j + direction[k][1];

                        if(!(0 <= next_r && next_r < R && 0 <= next_c && next_c < C )) //범위밖이면 제거
                            continue;

                        if((next_r == machine[0] && next_c ==0) || (next_r == machine[1] && next_c == 0)) //공기 청소기 위치여도 제거
                            continue;
                        
                        canSpreadCount++;

                        newMap[next_r][next_c] += spreadDustValue;
                    }
                    newMap[i][j] += curDustValue - (spreadDustValue * canSpreadCount);

                }

            }
        }
        newMap[machine[0]][0] = -1;
        newMap[machine[1]][0] = -1;

        // 만들어진 먼지 확산후 지도(newMap)을 map 에 복사한다.
        for (int i = 0; i < map.length; i++) {
            map[i] = Arrays.copyOf(newMap[i], newMap[i].length);
        }
        newMap = new int[R][C]; // 확산 지도는 다시 0으로 초기화
    }
    static void operationMachine(){

        //윗 청정기 부터 시작
        //역순으로 진행 아래, 왼쪽, 위 , 오른쪽
        //역순으로 하는 이유는 배열 shift할때 다음값이 사라지는거 방지

        // 아래쪽으로 이동한다.
        for (int i = machine[0]-1; i >= 0; i--) {
            int now = map[i][0];
            int after = map[i + 1][0];

            if(after == -1){
                // 청소기 위치면 사라지도록 pass
                map[i][0] = 0;//이동한셈 치고 0으로 초기화
                continue;
            }

            map[i+1][0] = now;
            map[i][0] = 0;//이동했으니 0으로 초기화
        }
        // 왼쪽으로 이동한다.
        for (int i = 0; i < C-1; i++) {
            int after = map[0][i+1];
            map[0][i] = after;
            map[0][i+1] = 0;//이동했으니 0으로 초기화
        }
        // 위쪽으로 이동한다.
        for (int i = 0; i < machine[0]; i++) {
            int after = map[i+1][C-1];
            map[i][C-1] = after;
            map[i+1][C-1] = 0;//이동했으니 0으로 초기화
        }
        // 오른쪽으로 이동한다.
        for (int i = C-1; i > 1; i--) {
            int after = map[machine[0]][i-1];
            map[machine[0]][i] = after;
            map[machine[0]][i-1] = 0;//이동했으니 0으로 초기화
        }


        //아랫 청정기 시작

        // 위쪽으로 이동한다.
        for (int i = machine[1] +1; i < R; i++) {
            int now = map[i][0];
            int after = map[i-1][0];

            if(after == -1){
                // 청소기 위치면 사라지도록 pass
                map[i][0] = 0;//이동한셈 치고 0으로 초기화
                continue;
            }

            map[i-1][0] = now;
            map[i][0] = 0;//이동했으니 0으로 초기화
        }
        // 왼쪽으로 이동한다.
        for (int i = 0; i < C-1; i++) {
            int after = map[R-1][i+1];
            map[R-1][i] = after;
            map[R-1][i+1] = 0;//이동했으니 0으로 초기화
        }
        // 아래쪽으로 이동한다.
        for (int i = R-1; i > machine[1]; i--) {
            int after = map[i-1][C-1];
            map[i][C-1] = after;
            map[i-1][C-1] = 0;//이동했으니 0으로 초기화
        }
        // 오른쪽으로 이동한다.
        for (int i = C-1; i > 1; i--) {
            int after = map[machine[1]][i-1];
            map[machine[1]][i] = after;
            map[machine[1]][i-1] = 0;//이동했으니 0으로 초기화
        }

    }
}
