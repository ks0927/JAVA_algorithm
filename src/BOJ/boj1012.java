package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj1012 {

    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] check;
    static int[][] map;
    static int result;
    static List<Integer> answerList;
    static int m;
    static int n;

    public void solution(int x, int y){

        for (int i = 0; i < 4; i++) { //4방향탐색
            int next_x = x + direction[i][0];
            int next_y = y + direction[i][1];

            //맵 내에 있어야함
            if(!(0<=next_x && next_x<m && 0<=next_y && next_y<n)) continue;

            if(check[next_x][next_y]==0 && map[next_x][next_y]==1){ //아직 안갔으면서 배추가있는경우
                check[next_x][next_y]=result; //체크값을 갔다고(현재 몇번째 배추모임인지) 바꿔준다.
                solution(next_x,next_y);  //재귀로 dfs
            }
        }


    }

    public static void main(String[] args) {
        boj1012 boj1012 = new boj1012();

        int t;
        int k;

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        answerList = new ArrayList<>();

        //테스트 케이스 갯수 t번만큼 실행
        for (int i = 0; i < t; i++) {

            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            //맵과 체크값 초기화
            map = new int[m][n];
            check = new int[m][n];

            //배추 모임 갯수
            result =0;

            for (int j = 0; j < k; j++) {

                int map_x = sc.nextInt();
                int map_y = sc.nextInt();
                map[map_x][map_y] = 1;
            }

            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if(check[j][l]==0 && map[j][l]==1){ //아직 간적없으면서 배추인경우
                        ++result;  //영역을 늘리고
                        check[j][l]=1; //갔다고 표시해주고
                        boj1012.solution(j,l); //dfs를 통해 해당 배추로부터 갈수있는 곳 끝까지 가보기
                    }
                }
            }
            answerList.add(result); //t번만큼 실행되면서 해당 결과값들을 저장
        }


        for (Integer integer : answerList) {
            System.out.println(integer); //정답 반환
        }
    }
}
