package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14890 {

    static int N;
    static int L;
    static int result;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j]= a;
            }
        }

        result = 0;
        visited = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            operationR(r);
        }
//        System.out.println("R result = " + result);

        visited = new boolean[N][N];
        for (int c = 0; c < N; c++) {
            operationC(c);
        }

        System.out.println(result);
    }

    static void operationR(int index){

        int[] row = new int[N];

        for (int i = 0; i < N ; i++) {
            int nowValue = map[index][i];
            row[i] = nowValue;

            int nextIndex = i+1;

            if(!(0<=nextIndex && nextIndex<N)) //다음값이 범위밖이면 넘겨
                continue;

            int nextValue = map[index][nextIndex]; //다음값
            if(nextValue > nowValue){ //상승의 경우
                int distance = nextValue - nowValue;

                if(distance !=1) //경사차가 1이상이면 실패
                    return;

                int countL = 0;
                //경사로를 놓을수 있는지 현재부터 시작해서 값들을 L번 되돌아가면서 확인
                for (int j = 0; j < L; j++) {
                    int backIndex = i-j;
                    if(!(0<=backIndex && backIndex<N)) //이전값이 범위밖이면 실패
                        return;
                    if(visited[index][backIndex]){ //가본적이 있는 즉, 경사로가 이미 놓여진곳이면 실패
                        return;
                    }
                    int checkL = map[index][backIndex];

                    if(checkL == nowValue){ //현재값하고 같으면 +1
                        countL++;
                        visited[index][backIndex] =true;
                    }
                }
                if(countL !=L){ //경사로 놓을 길이가 부족하면 실패
                    return;
                }
            }
            //여기까지 나왔다면 상승 성공

            if(nextValue < nowValue){ //하강의 경우
                int distance = nowValue- nextValue;

                if(distance !=1) //경사차가 1이상이면 실패
                    return;

                int countL = 0;
                //경사로를 놓을수 있는지 다음값부터 시작해서 값들을 L번 되돌아가면서 확인
                for (int j = 1; j <= L; j++) {
                    int afterIndex = i+j;
                    if(!(0<=afterIndex && afterIndex<N)) //이후값이 범위밖이면 실패
                        return;
                    if(visited[index][afterIndex]){ //가본적이 있는 즉, 경사로가 이미 놓여진곳이면 실패
                        return;
                    }
                    int checkL = map[index][afterIndex];

                    if(checkL == nextValue){ //다음값하고 같으면 +1
                        countL++;
                        visited[index][afterIndex] =true;
                    }
                }
                if(countL !=L){ //경사로 놓을 길이가 부족하면 실패
                    return;
                }
            }
            //여까지 나왔다면 하강 성공
        }

//        System.out.println("index = " + index);
        //for문을 성공했다면 잘 지나갔다는것
        result++;

    }

    static void operationC(int index){
        int[] column = new int[N];

        for (int i = 0; i < N ; i++) {
            int nowValue = map[i][index];
            column[i] = nowValue;

            int nextIndex = i+1;

            if(!(0<=nextIndex && nextIndex<N)) //다음값이 범위밖이면 넘겨
                continue;

            int nextValue = map[nextIndex][index]; //다음값
            //상승의 경우
            if(nextValue > nowValue){
                int distance = nextValue - nowValue;

                if(distance !=1) //경사차가 1이상이면 실패
                    return;

                int countL = 0;
                //경사로를 놓을수 있는지 현재부터 시작해서 값들을 L번 되돌아가면서 확인
                for (int j = 0; j < L; j++) {
                    int backIndex = i-j;
                    if(!(0<=backIndex && backIndex<N)) //이전값이 범위밖이면 실패
                        return;
                    if(visited[backIndex][index]){ //가본적이 있는 즉, 경사로가 이미 놓여진곳이면 실패
                        return;
                    }
                    int checkL = map[backIndex][index];

                    if(checkL == nowValue){ //현재값하고 같으면 +1
                        countL++;
                        visited[backIndex][index] =true;
                    }
                }
                if(countL !=L){ //경사로 놓을 길이가 부족하면 실패
                    return;
                }
            }
            //여기까지 나왔다면 상승 성공

            //하강의 경우
            if(nextValue < nowValue){
                int distance = nowValue- nextValue;

                if(distance !=1) //경사차가 1이상이면 실패
                    return;

                int countL = 0;
                //경사로를 놓을수 있는지 다음값부터 시작해서 값들을 L번 되돌아가면서 확인
                for (int j = 1; j <= L; j++) {
                    int afterIndex = i+j;
                    if(!(0<=afterIndex && afterIndex<N)) //이후값이 범위밖이면 실패
                        return;
                    if(visited[afterIndex][index]){ //가본적이 있는 즉, 경사로가 이미 놓여진곳이면 실패
                        return;
                    }
                    int checkL = map[afterIndex][index];

                    if(checkL == nextValue){ //다음값하고 같으면 +1
                        countL++;
                        visited[afterIndex][index] =true;
                    }
                }
                if(countL !=L){ //경사로 놓을 길이가 부족하면 실패
                    return;
                }
            }
            //여까지 나왔다면 하강 성공
        }

//        System.out.println("index = " + index);
        //for문을 성공했다면 잘 지나갔다는것
        result++;

    }
}
