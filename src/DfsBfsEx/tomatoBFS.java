package DfsBfsEx;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tomatoBFS {
    static int[][] direction ={{-1,0},{1,0},{0,-1},{0,1}}; // 위 아래 왼쪽 오른쪽
    static int[][] chest;
    static int m;
    static int n;
    static int answer=0;

    public void BFS(int day){
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(chest[i][j]==1){
                    queue.offer(new Point(j,i)); //초기값 큐에 삽입
//                    System.out.println("i = " + i);
//                    System.out.println("j = " + j);
                }
            }
        }

        while(!queue.isEmpty()){
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Point poll = queue.poll();
                for (int j = 0; j < 4; j++) { //위 아래 왼쪽 오른쪽 탐색
                    int next_y = poll.y + direction[j][0];
                    int next_x = poll.x + direction[j][1];

                    if(0<=next_x && next_x<m && 0<=next_y && next_y<n && chest[next_y][next_x]==0){
                        chest[next_y][next_x]=1;
                        queue.offer(new Point(next_x,next_y));
                    }
                }
            }
/*            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(chest[i][j]+" ");
                }
                System.out.println();
            }*/
            answer++;
            //System.out.println("answer = " + answer);
        }
    }

    public static void main(String[] args) {
        tomatoBFS T = new tomatoBFS();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        chest = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                chest[i][j] = kb.nextInt();
            }
        }
        T.BFS(0);

        boolean flag =false; //남은 0값이 있음? 즉 모두 못익는 상황임
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(chest[i][j]==0){
                    flag=true;  //못익는 경우 있음
                }
            }
        }
        if(flag)
            System.out.print(-1);// 전부 못익는 경우
        else
            System.out.print(answer-1);  //answer에서 -1을 하는 이유는 나는 큐에 집어넣는값이 갈수있는곳의 값인데
                                        // 이러면 다 1인 상황에서도 있나 없나찾아야해서 answer가 한번더 +1 된다.
                                        // 그걸 -1로 한번 지워주는것! 물론 내부적으로 거를수도 있겠지만 구찮...

    }
}
