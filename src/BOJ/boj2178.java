package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {
    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int M;
    static int result;
    static int[][] map;
    static int[][] route;
    static boolean[][] visited;
    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        route = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken(); //숫자가 다 붙어있기때문에 string에서 하나씩 뽑는과정이 필요함

            for (int j = 0; j < s.length(); j++) {
                int a = Integer.parseInt(String.valueOf(s.charAt(j))); //chatAt으로 하나씩 가져오는데 parseInt는 String이 필요해서 다시String으로 변환해줌
                map[i][j] = a;
            }
        }

/*        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

        visited = new boolean[N][M];
        result = 1;
        BFS(0, 0);

        System.out.println(result);

    }

    static void BFS(int r, int c){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r,c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            ++result;  //항상 result의 위치를 생각하자 이거때문에 숫자값난리났음
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                for (int j = 0; j < 4; j++) { //위 아래 왼쪽 오른쪽 탐색
                    int next_r = poll.r + direction[j][0];
                    int next_c = poll.c + direction[j][1];

                    //map 내부 값 처리
                    if (!(0 <= next_r && next_r < N && 0 <= next_c && next_c < M)) {
                        continue;
                    }

                    if(next_r == N-1 && next_c == M-1)
                        return ;

                    if(map[next_r][next_c] == 1 && !visited[next_r][next_c]){
                        visited[next_r][next_c] = true;
                        route[next_r][next_c] = result;
                        queue.add(new Node(next_r,next_c));
                    }

                }
            }

/*            System.out.println("루트표시");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(route[i][j]);
                }
                System.out.println();
            }*/
        }
    }
}
