import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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
                check[next_x][next_y]=result;
                solution(next_x,next_y);
            }
        }


    }

    public static void main(String[] args) {
        Main boj1012 = new Main();

        int t;
        int k;

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        answerList = new ArrayList<>();
        for (int i = 0; i < t; i++) {

            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            map = new int[m][n];
            check = new int[m][n];

            result =0;

            for (int j = 0; j < k; j++) {

                int map_x = sc.nextInt();
                int map_y = sc.nextInt();
                map[map_x][map_y] = 1;
            }

            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if(check[j][l]==0 && map[j][l]==1){
                        ++result;
                        check[j][l]=1;
                        boj1012.solution(j,l);
                    }
                }
            }
//            System.out.println("result = " + result);
            answerList.add(result);
        }


        for (Integer integer : answerList) {
            System.out.println(integer);
        }
    }
}
