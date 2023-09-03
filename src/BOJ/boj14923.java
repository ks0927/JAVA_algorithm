package BOJ;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int x;
    int y;
    int useWand;

    public Node(int x, int y, int useWand) {
        this.x = x;
        this.y = y;
        this.useWand = useWand;
    }
}
public class boj14923 {

    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] maze;
    static boolean[][][] visited;
    static int N;
    static int M;
    static int Ex;
    static int Ey;

    public int solution(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));
        visited[x][y][0] =true;
        int result =0;

        while(!queue.isEmpty()){ //큐가 비었니
            ++result;
            int size = queue.size();
            for (int s = 0; s < size; s++) {   //bfs 특징 :레벨별 처리, 만약 현재 for문이 끝난다면 한level이 끝난것 ==즉 result+1, 한걸음 이동
                Node now = queue.poll();

                for (int i = 0; i < 4; i++) { //위 아래 왼쪽 오른쪽 탐색
                    int next_x = now.x + direction[i][0];
                    int next_y = now.y + direction[i][1];

                    //만들어둔 maze 조건을 넘어서지 않는지 확인
                    if(!(1<=next_x&& next_x<=N &&1<=next_y&& next_y<=M)) {
                        continue;
                    }

                    //벽이라면
                    if(maze[next_x][next_y]==1){
                        //지팡이를 사용할수있고 방문하지 않았다면
                        if(now.useWand==0 && !visited[next_x][next_y][now.useWand+1]){ //즉 boolean 배열의 1값이 false라면 안쓴거겠지
                            //그리고 이동할 위치가 탈출위치면 반환
                           if(next_x==Ex && next_y==Ey) {
                               return result;
                           }


                            queue.add(new Node(next_x,next_y,now.useWand+1));
                            visited[next_x][next_y][now.useWand+1]=true;     //미리 갔다고 찍어놔야지 중복의 문제를 해결하고 성능최적화가 가능하다

                        }
                    }
                    //벽이 아니라면
                    else {
                        //방문한적 없다면
                        if(!visited[next_x][next_y][now.useWand]){
                            //그리고 이동할 위치가 탈출위치면 반환
                            if(next_x==Ex && next_y==Ey) {
                                return result;
                            }

                            queue.add(new Node(next_x,next_y,now.useWand));
                            visited[next_x][next_y][now.useWand]=true;    //미리 갔다고 찍어놔야지 중복의 문제를 해결하고 성능최적화가 가능하다
                        }
                    }

                }
            }

        }
        //탈출할수없다면
        return -1;
    }

    public static void main(String[] args) {
        boj14923 boj = new boj14923();
        Scanner sc = new Scanner(System.in);

        int Hx;
        int Hy;
        N = sc.nextInt();
        M = sc.nextInt();
        Hx = sc.nextInt();
        Hy = sc.nextInt();
        Ex = sc.nextInt();
        Ey = sc.nextInt();

        maze = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];
        //미로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        int solution = boj.solution(Hx, Hy);
        System.out.print(solution);

    }
}
