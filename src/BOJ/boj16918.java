package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj16918 {
    static int R;
    static int C;
    static int N;
    static String[][] map;
    static ArrayList<Point> bombPoint;
    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        bombPoint =new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = String.valueOf(s.charAt(j));
                if(String.valueOf(s.charAt(j)).equals("O")){
                    bombPoint.add(new Point(i,j));
                }
            }
        }

/*        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

        int count = 1;
        while(count < N){
            ++count;

            //2,4,6... 번째 특징은 항상 다 맵을 폭탄으로 채운다는것이다.
            if(count %2 == 0){
                setAllO();
            }
            else {
                bombBoom();
            }

        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    //모든칸을 폭탄으로 채우는 메서드
    private static void setAllO() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = "O";
            }
        }
    }

    //이전에 저장해둔 터질위치를 토대로 폭탄을 터트리는 메서드
    //폭탄을 터트린뒤 남은 폭탄의 위치를 for문을 돌면서 저장해둔다.
    //그래야 다음에 또 터질위치를알수있음

    private static void bombBoom() {

        for (Point point : bombPoint) {

            map[point.r][point.c] = ".";
            for (int j = 0; j < 4; j++) { //위 아래 왼쪽 오른쪽 탐색
                int next_r = point.r + direction[j][0];
                int next_c = point.c + direction[j][1];

                //map 내부 값 처리
                if (!(0 <= next_r && next_r < R && 0 <= next_c && next_c < C)) {
                    continue;
                }

                map[next_r][next_c] = ".";
            }

        }

        bombPoint.clear(); // 터질위치 clear

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j].equals("O")){
                    bombPoint.add(new Point(i,j)); //다음에 터질위치 집어넣기
                }
            }
        }


    }
}
