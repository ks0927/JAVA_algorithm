package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11559 {

    static int result;
    static int count;
    static ArrayList<String> mapColumn;
    static String[][] map;
    static int[][] visited;
    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

    static class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        map = new String[12][6];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 12; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                String c = String.valueOf(s.charAt(j));
                map[i][j] = c;
            }
        }

        result = 0;

        while(true){
            visited = new int[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    count = 1;
                    // . 이 아니고 아직 체크못한 곳이면 bfs 실행
                    if(!map[i][j].equals(".") && visited[i][j] == 0){
                        countDFS(i,j);
                    }
                }
            }
/*            System.out.println("현재visited배열");
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(visited[i][j]);
                }
                System.out.println();
            }*/

            //visited 배열에서 4이상의 값이 있다면 터질게 있다는것
            if(CheckBoom()){
                //터지는 로직
                Boom();
            }
            else{
                break;
            }

/*            System.out.println("현재 map배열");
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }*/
        }

        System.out.println(result);

    }

    static void countDFS(int r, int c){

        String nowColor = map[r][c];
        visited[r][c] = count;

        for (int i = 0; i < 4; i++) {//위 아래 왼쪽 오른쪽 탐색
            int next_r = r + direction[i][0];
            int next_c = c + direction[i][1];

            if(!(0 <= next_r && next_r < 12 && 0 <= next_c && next_c < 6 )) //범위밖이면 제거
                continue;

            if(map[next_r][next_c].equals(nowColor) && visited[next_r][next_c] == 0){
                ++count;
                countDFS(next_r,next_c);
            }

        }
        visited[r][c] = count; //DFS가 끝나면 count값이 변경되어있을테니 재 초기화

    }

    static void boomCheckDFS(int r, int c){

        String nowColor = map[r][c];
        map[r][c] = ".";
        visited[r][c] = 0;

        for (int i = 0; i < 4; i++) {//위 아래 왼쪽 오른쪽 탐색
            int next_r = r + direction[i][0];
            int next_c = c + direction[i][1];

            if(!(0 <= next_r && next_r < 12 && 0 <= next_c && next_c < 6 )) //범위밖이면 제거
                continue;

            if(map[next_r][next_c].equals(nowColor)){
                boomCheckDFS(next_r,next_c);
            }

        }

    }

    static boolean CheckBoom(){

        for (int i = 11; i >= 0; i--) {
            for (int j = 5; j >= 0; j--) {
                if(visited[i][j] >= 4){
                    return true;
                }
            }
        }
        return false;
    }

    static void Boom(){

        // 4보다 큰 값을 터트린다. 즉 map을 .으로바꾼다
        // 다만 DFS를 돌면서 같은 색일때만 터뜨린다.
        for (int i = 11; i >= 0; i--) {
            for (int j = 5; j >= 0; j--) {
                if(visited[i][j] >= 4){
                    boomCheckDFS(i,j);
                }
            }
        }
        result++;


        //칼럼을 하나씩 순회한다.
        for (int i = 0; i < 6; i++) {
            mapColumn = new ArrayList<>();
            // .을 제외한 값을 담는다
            for (int j =11; j >= 0; j--) {
                if(!(map[j][i].equals("."))){
                    mapColumn.add(map[j][i]);
                }
            }
            //현재 칼럼을 .으로 초기화한다.
            for (int j = 0; j < 12; j++) {
                map[j][i] =".";
            }


            int index =11;
            for (int j = 0; j < mapColumn.size(); j++) {
                map[index][i] = mapColumn.get(j);
                index--;
            }
/*            System.out.println("현재 중력 테스트배열");
            for (int h = 0; h < 12; h++) {
                for (int z = 0; z < 6; z++) {
                    System.out.print(map[h][z]);
                }
                System.out.println();
            }*/
        }


 /*       System.out.println("현재 boom 뒤map배열");
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

    }


}
