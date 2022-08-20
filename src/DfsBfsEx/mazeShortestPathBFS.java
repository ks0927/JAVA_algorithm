package DfsBfsEx;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class mazeShortestPathBFS {
    static int[][] direction ={{-1,0},{1,0},{0,-1},{0,1}}; // 위 아래 왼쪽 오른쪽
    static int[][] maze;
    static int[][] path;

    public void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y)); //초기값 큐에 삽입
        path[x][y]=1;  //초기 시작위치 미리 삽입
        while(!queue.isEmpty()){
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) { //위 아래 왼쪽 오른쪽 탐색
                int next_y = poll.y + direction[i][0];
                int next_x = poll.x + direction[i][1];
                //
                if(0<=next_x && next_x<7 && 0<=next_y && next_y<7 && maze[next_y][next_x]==0 &&path[next_y][next_x]==0 ){
                    path[next_y][next_x] =path[poll.y][poll.x]+1;
                    queue.offer(new Point(next_x,next_y));
                }
            }
        }
    }

    public static void main(String[] args) {
        mazeShortestPathBFS M = new mazeShortestPathBFS();
        Scanner kb = new Scanner(System.in);
        maze = new int[7][7];
        path = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                maze[i][j]= kb.nextInt();
            }
        }
        M.BFS(0,0);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                path[i][j]-=1;  //시작이 1이었으니까 전부 -1해줘야함
                //System.out.print(path[i][j]+" ");
            }
            //System.out.println();
        }

        if(path[6][6] == -1) //못감
            System.out.println(-1);
        else{
            System.out.println(path[6][6]);
        }
    }
}
