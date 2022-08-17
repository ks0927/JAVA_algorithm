package DfsBfsEx;

import java.util.Scanner;

public class mazeRoadNumber {
    static int[][] direction ={{-1,0},{1,0},{0,-1},{0,1}}; // 뒤 앞 왼쪽 오른쪽
    static int[][] maze; //n보다 1크게해서 편하게
    static int road=0;
    public void DFS(int y, int x){
        if(y==7 && x==7){
            road++;
        }
        else{
            for (int i = 0; i < 4; i++) {
                int next_y = y + direction[i][0];
                int next_x = x + direction[i][1];

                if(0<next_x && next_x<8 && 0<next_y && next_y<8 && maze[next_y][next_x]==0 ){
                    maze[next_y][next_x] =1;
                    DFS(next_y,next_x);
                    maze[next_y][next_x] =0;
                }
            }
        }
    }
    public static void main(String[] args) {
        mazeRoadNumber M = new mazeRoadNumber();
        Scanner kb= new Scanner(System.in);

        maze = new int[8][8];
        for (int i = 1; i <8; i++) {
            for (int j = 1; j < 8; j++) {
                maze[i][j] = kb.nextInt();
            }
        }
        maze[1][1]=1;  // 이거 깜빡했다가 답이 2배로 나옴 ㅋㅋ 조심하자
        M.DFS(1,1);
        System.out.println(road);
    }
}
